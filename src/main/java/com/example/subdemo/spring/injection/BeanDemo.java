package com.example.subdemo.spring.injection;

import javax.annotation.Resource;

public class BeanDemo {

    @Resource
    private BeanDependency beanDependency;

    public void method() {
        beanDependency.method();
    }

}