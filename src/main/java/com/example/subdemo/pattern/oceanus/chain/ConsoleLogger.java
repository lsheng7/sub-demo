package com.example.subdemo.pattern.oceanus.chain;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("info: " + message);
    }
}