package com.example.subdemo.pattern.proxy.jdk;

public class UserService2 {

    public void add() {
        System.out.println("com.example.subdemo.pattern.proxy.jdk.UserService2.add");
    }

    public String say() {
        System.out.println("com.example.subdemo.pattern.proxy.jdk.UserService2.say");
        return "hello";
    }

}
