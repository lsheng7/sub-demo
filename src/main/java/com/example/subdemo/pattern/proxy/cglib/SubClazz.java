package com.example.subdemo.pattern.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class SubClazz extends ParentClazz {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "E:\\personal\\project\\demo\\target\\classes");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ParentClazz.class);

        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            System.out.println("before");
            Object result = proxy.invokeSuper(obj, args1);
            System.out.println("after");
            return result;
        });
        Inter sample = (Inter) enhancer.create();
        sample.inter();
    }

    @Override
    void method() {
        System.out.println("SubClazz method");
    }
}
