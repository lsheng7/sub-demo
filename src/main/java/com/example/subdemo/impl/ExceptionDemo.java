package com.example.subdemo.impl;

public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println(method());
    }

    public static boolean method() {

        try {
            int i = 10 / 0;
        } catch (Exception exception) {
            return false;
        }
        return true;
    }
}
