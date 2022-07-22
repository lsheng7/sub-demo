package com.example.subdemo.pattern.proxy.cglib;

public interface Inter {

    void inter();


    default void method() {
        System.out.println("method");
    }
}
