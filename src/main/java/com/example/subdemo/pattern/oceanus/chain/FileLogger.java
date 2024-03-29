package com.example.subdemo.pattern.oceanus.chain;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("debug: " + message);
    }
}