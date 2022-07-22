package com.example.subdemo.basic;

import java.lang.reflect.Method;

public class Parent {

    public void method() {
        System.out.println("Parent.method");
    }
}

class Sub extends Parent {

    public static void main(String[] args) throws Exception {
        Sub sub = new Sub();
        Method method = sub.getClass().getSuperclass().getMethod("method");
        System.out.println(method);
        method.invoke(sub);
    }

    @Override
    public void method() {
        System.out.println("Sub.method");
    }

}