package com.example.subdemo.pattern.proxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TestCGLib implements MethodInterceptor {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "E:\\personal\\project\\demo\\target\\classes");

        TestCGLib testCGLib = new TestCGLib();
        Inter inter = (Inter) testCGLib.getInstance(Inter.class);
        inter.inter();
    }

    public Object getInstance(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args1, MethodProxy proxy) throws Throwable {
        System.out.println("before");
        Object result = proxy.invokeSuper(obj, args1);
        System.out.println("after");
        return result;
    }
}
