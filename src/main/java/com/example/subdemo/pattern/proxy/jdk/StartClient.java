package com.example.subdemo.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class StartClient {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //真实对象
        Star realStar = new RealStar();
        //InvocationHandlerImpl 实现了InvocationHandler接口 并能实现方法调用从代理类到委托类的分派转发
        //其内部通常包含指向委托类实例的引用 用于真正执行分派转发过来的方法调用
        //即: 要代理哪个真实对象 就将该对象传进去 最后是通过该真实对象来调用其方法
        InvocationHandler handler = new StartInvocationHandler(realStar);
        ClassLoader loader = realStar.getClass().getClassLoader();
        Class[] interfaces = realStar.getClass().getInterfaces();
        //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        //隐式调用了hashCode及equals方法
        Star proxyStar = (Star) Proxy.newProxyInstance(loader, interfaces, handler);
        System.out.println(proxyStar);
        System.out.println("动态代理对象的类型：" + proxyStar.getClass().getName());
        System.out.println("-------------------------------------------------------------");
        proxyStar.sing();
//        proxyStar.toString();
//        System.out.println("-------------------------------------------------------------");
//        proxyStar.hashCode();
    }
}
