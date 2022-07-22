package com.example.subdemo.basic;

public interface DefaultMethodInter {


    default void method() {
        System.out.println("method");
    }
}
