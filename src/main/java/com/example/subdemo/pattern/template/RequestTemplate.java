package com.example.subdemo.pattern.template;

import cn.hutool.http.HttpRequest;


/**
 * 请求外部接口模板类
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/02/24 14:28
 */
public abstract class RequestTemplate<Dto, Bo> {


    /**
     * 请求第三方接口
     *
     * @param dto 请求实体
     * @param clazz clazz
     * @return {@link Bo }
     * @author lvsheng
     * @date 2022/02/24 14:28
     */
    public final Bo doRequest(Dto dto, Class<? extends Bo> clazz) {
        HttpRequest request = preRequest(dto);
        return parseResponse(doRequest(request), clazz);
    }


    /**
     * 构造请求报文
     *
     * @param dto 请求实体
     * @return {@link HttpRequest }
     * @author lvsheng
     * @date 2022/02/24 14:28
     */
    protected abstract HttpRequest preRequest(Dto dto);


    /**
     * 发送请求
     *
     * @param request 请求
     * @return {@link String }
     * @author lvsheng
     * @date 2022/02/24 14:28
     */
    protected abstract String doRequest(HttpRequest request);


    /**
     * 解析响应结果
     *
     * @param result 结果
     * @param clazz clazz
     * @return {@link Bo }
     * @author lvsheng
     * @date 2022/02/24 14:28
     */
    protected abstract Bo parseResponse(String result, Class<? extends Bo> clazz);
}
