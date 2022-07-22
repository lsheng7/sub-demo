package com.example.subdemo.spring.injection;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@DependsOn("dependsOnServiceImpl")
@Component
public class BeanDependency {

    public BeanDependency() {
        System.out.println("BeanDependency constructor invoked");
    }

    public void method() {
        System.out.println("com.example.subdemo.spring.injection.BeanDependency.method");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("com.example.subdemo.spring.injection.BeanDependency.postConstruct");
    }
}
