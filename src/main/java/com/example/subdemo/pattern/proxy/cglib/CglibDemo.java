package com.example.subdemo.pattern.proxy.cglib;

import cn.hutool.core.util.StrUtil;
import java.lang.reflect.Method;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDemo {

    //动态代理会生成3个类
    //public class Demo$$EnhancerByCGLIB$$d2f57f49 extends Demo implements Factory
    //Demo$$EnhancerByCGLIB$$d2f57f49$$FastClassByCGLIB$$13110ad
    //public class Demo$$FastClassByCGLIB$$35162b8a extends FastClass
    public static void main(String[] args) {
        //设置 cglib动态生成的class文件存储路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "E:\\personal\\project\\demo\\target\\classes");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Demo.class);
        //如果设置了多个Callback需要额外指定另一个组件CallbackFilter
        enhancer.setCallbacks(new Callback[]{new MethodInterceptorImpl(), new MethodInterceptorImpl2()});
        enhancer.setCallbackFilter(new CglibCallbackFilter());
        Demo sample = (Demo) enhancer.create();
        System.out.println("--------------------------------------------------------");
        //可以观察到final、static、private方法都不会被cglib代理
        sample.staticTest();
        System.out.println("--------------------------------------------------------");
        sample.finalTest();
        System.out.println("--------------------------------------------------------");
//        sample.privateMethod();
        System.out.println("--------------------------------------------------------");
        sample.test();
        System.out.println("--------------------------------------------------------");
        sample.method();
        System.out.println("=========================================================");
    }
}

//Exception in thread "main" java.lang.IllegalArgumentException: Cannot subclass final class class com.example.subdemo.pattern.proxy.cglib.Demo
//如果类是final cglib代理直接报上面异常
//final
class Demo {

    public static void staticTest() {
        System.out.println("staticTest");
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    public void test() {
        System.out.println("test");
    }

    public void method() {
        System.out.println("method");
    }

    public final void finalTest() {
        System.out.println("finalTest");
    }
}

class CglibCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        final String methodName = method.getName();
        //如果调用test方法会使用index=1的Callback即MethodInterceptorImpl2
        if (StrUtil.equals(methodName, "test")) {
            return 1;
        }
        //调用除test方法外的非final方法会使用index=1的Callback即MethodInterceptorImpl2
        return 0;
    }
}


class MethodInterceptorImpl implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args1, MethodProxy proxy) throws Throwable {
        System.out.println("com.example.subdemo.pattern.proxy.cglib.MethodInterceptorImpl.intercept before method run...");
        Object result = proxy.invokeSuper(obj, args1);
        System.out.println("com.example.subdemo.pattern.proxy.cglib.MethodInterceptorImpl.intercept after method run...");
        return result;
    }
}

class MethodInterceptorImpl2 implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args1, MethodProxy proxy) throws Throwable {
        System.out.println("com.example.subdemo.pattern.proxy.cglib.MethodInterceptorImpl2.intercept before method run...");
        Object result = proxy.invokeSuper(obj, args1);
        System.out.println("com.example.subdemo.pattern.proxy.cglib.MethodInterceptorImpl2.intercept after method run...");
        return result;
    }
}
