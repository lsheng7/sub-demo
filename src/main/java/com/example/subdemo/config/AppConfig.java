package com.example.subdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${app}")
    private String app;

    public static void main(String[] args) {
        String a = "a%s%s";
        System.out.println(String.format(a, "b", "c"));
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
}
