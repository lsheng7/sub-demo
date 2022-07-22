package com.example.subdemo.config;

import com.example.subdemo.interceptor.RequestAttributeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * Spring 3.2就已经支持@MatrixVariable特性，但直至现在其依然为默认禁用的状态
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/03/08 13:14
 * @see WebMvcConfigurer
 */
@Configuration
public class MatrixVariableConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new RequestAttributeInterceptor()).addPathPatterns("/**/request-attribute", "/**/session-attribute");
    }
}