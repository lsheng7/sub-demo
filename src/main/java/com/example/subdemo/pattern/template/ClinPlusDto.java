package com.example.subdemo.pattern.template;

import cn.hutool.http.Method;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ClinPlusDto {

    /**
     * 请求url
     */
    private String url;

    /**
     * 请求方法类型
     */
    private Method method = Method.GET;

    /**
     * 请求方式-body-param-path
     */
    private RequestMode mode = RequestMode.PARAM;
}
