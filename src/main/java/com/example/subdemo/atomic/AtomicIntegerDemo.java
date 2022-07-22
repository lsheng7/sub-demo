package com.example.subdemo.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    static int a;
    static boolean b;
    static double c;
    public static void main(String[] args) {
        System.out.println(new AtomicInteger().get());
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
