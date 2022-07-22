package com.example.subdemo.pattern.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 代理-实现接口的类
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/06/02 14:39
 * @see Inter
 */
public class InterImpl implements Inter {

    //public class InterImpl$$EnhancerByCGLIB$$9c23d4da extends InterImpl implements Factory
    //public class InterImpl$$EnhancerByCGLIB$$9c23d4da$$FastClassByCGLIB$$c05d9329 extends FastClass
    //public class InterImpl$$FastClassByCGLIB$$c86eafd5 extends FastClass
    public static void main(String[] args) {
//        error
//        testProxyInter();
        testProxyInterImpl();
    }

    public static void testProxyInterImpl() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "E:\\personal\\project\\demo\\target\\classes");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InterImpl.class);

        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            System.out.println("before");
            Object result = proxy.invokeSuper(obj, args1);
            System.out.println("after");
            return result;
        });
        Inter sample = (Inter) enhancer.create();
//        sample.method();
        sample.inter();
    }

    public static void testProxyInter() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "E:\\personal\\project\\demo\\target\\classes");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Inter.class);

        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            System.out.println("before");
            Object result = proxy.invokeSuper(obj, args1);
            System.out.println("after");
            return result;
        });
        Inter sample = (Inter) enhancer.create();
//        sample.method();
        sample.inter();
    }

    @Override
    public void inter() {
        System.out.println("inter");
    }
}
