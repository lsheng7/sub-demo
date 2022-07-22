package com.example.subdemo.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkInvocationHandler implements InvocationHandler {

    //这个就是我们要代理的真实对象
    private final Object object;

    //构造方法，给我们要代理的真实对象赋初值
    public JdkInvocationHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass());
        System.out.println("method:" + method);
        return method.invoke(object, args);
    }

}