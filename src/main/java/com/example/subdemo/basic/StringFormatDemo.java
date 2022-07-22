package com.example.subdemo.basic;

public class StringFormatDemo {

    public static void main(String[] args) {

        System.out.println(String.format("%s-%d-%s", "挣了", 10_000L, "元"));
        System.out.println(String.format("%x", 63));
    }
}
