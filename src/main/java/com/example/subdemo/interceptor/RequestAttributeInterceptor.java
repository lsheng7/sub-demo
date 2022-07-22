package com.example.subdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class RequestAttributeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("username", "小喇叭");
        //设置session属性
        HttpSession session = request.getSession();
        session.setAttribute("age", 100);
        return true;
    }

}
