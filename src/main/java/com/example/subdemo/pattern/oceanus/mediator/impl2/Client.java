package com.example.subdemo.pattern.oceanus.mediator.impl2;

public class Client {

    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");
        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
