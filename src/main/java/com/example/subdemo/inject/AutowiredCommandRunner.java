package com.example.subdemo.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AutowiredCommandRunner implements ApplicationRunner {


    /***
     * autowired 不加Qualifier都能按照名称注入
     * 前提字段名称必须符合bean名称
     */
    @Autowired
    private AutowiredInterface autowiredImpl2;

    @Autowired
    private AutowiredInterface autowired;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(autowiredImpl2);
        System.out.println(autowired);
    }

}
