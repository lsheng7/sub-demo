package com.example.subdemo.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvisor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before intercept");
        invocation.proceed();
        System.out.println("after intercept");
        return null;
    }
}
