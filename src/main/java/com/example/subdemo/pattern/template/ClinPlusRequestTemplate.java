package com.example.subdemo.pattern.template;

import static com.example.subdemo.pattern.template.ClinPlusConstant.CLIN_PLUS_LOGIN_URL;
import static com.example.subdemo.pattern.template.ClinPlusConstant.EMP_ID;
import static com.example.subdemo.pattern.template.ClinPlusConstant.HEADER_TOKEN;
import static com.example.subdemo.pattern.template.ClinPlusConstant.IGNORE_FILEDS;
import static com.example.subdemo.pattern.template.ClinPlusConstant.PASSWORD;
import static com.example.subdemo.pattern.template.ClinPlusConstant.SUCCESS_MSG;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 普蕊斯接口请求模板
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/02/24 10:21
 * @see RequestTemplate
 */
public class ClinPlusRequestTemplate extends RequestTemplate<ClinPlusDto, ClinPlusBo> {

    /**
     * 获取接口调用令牌
     *
     * @return {@link String }
     * @author lvsheng
     * @date 2022/02/24 10:35
     */
    private static String getToken() {

        //TODO 缓存中获取 EMP_ID:empId
        String token = null;
        UserDto userDto = new UserDto().setEmpId(EMP_ID).setPassword(PASSWORD);
        String jsonResult = HttpUtil.post(CLIN_PLUS_LOGIN_URL, JSONUtil.toJsonStr(userDto));

        ClinPlusEmpBo clinPlusEmpBo = JSONUtil.toBean(jsonResult, ClinPlusEmpBo.class);
        if (StrUtil.equals(SUCCESS_MSG, clinPlusEmpBo.getMsg())) {
            //TODO 缓存 2h
            token = clinPlusEmpBo.getData().getToken();
        }
        return token;
    }

    /**
     * 构建请求
     *
     * @param clinPlusDto 中国+请求实体
     * @return {@link HttpRequest }
     * @author lvsheng
     * @date 2022/02/24 15:35
     */
    @Override
    protected HttpRequest preRequest(ClinPlusDto clinPlusDto) {
        HttpRequest httpRequest = null;

        switch (clinPlusDto.getMethod()) {
            case GET:
                httpRequest = HttpRequest.get(clinPlusDto.getUrl());
                switch (clinPlusDto.getMode()) {
                    case PARAM:
                        Map<String, Object> formMap = new HashMap<>();
                        BeanUtil.copyProperties(clinPlusDto, formMap, IGNORE_FILEDS);
                        httpRequest = httpRequest.form(formMap);
                    case BODY:
                        //TODO
                        break;
                    default:
                        break;
                }
                break;
            case POST:
                //TODO
                break;
            case PUT:
                //TODO
                break;
            default:
                break;
        }

        httpRequest.header(HEADER_TOKEN, getToken());
        return httpRequest;
    }

    /**
     * 执行请求
     *
     * @param request 请求
     * @return {@link String }
     * @author lvsheng
     * @date 2022/02/24 15:35
     */
    @Override
    protected String doRequest(HttpRequest request) {
        return request.execute().body();
    }

    /**
     * 解析响应
     *
     * @param jsonResult json结果
     * @param clazz clazz
     * @return {@link ClinPlusBo }
     * @author lvsheng
     * @date 2022/02/24 15:35
     */
    @Override
    protected ClinPlusBo parseResponse(String jsonResult, Class<? extends ClinPlusBo> clazz) {
        return JSONUtil.toBean(jsonResult, clazz);
    }

    @Data
    @Accessors(chain = true)
    private final static class UserDto {

        private String empId;

        private String password;
    }

}
