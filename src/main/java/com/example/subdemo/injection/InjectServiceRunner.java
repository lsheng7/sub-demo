package com.example.subdemo.injection;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InjectServiceRunner implements ApplicationRunner {

    @Autowired
    private InjectService injectService;

    @Resource
    private InjectService injectService2;

    @Autowired
    private Map<String,InjectService> map;
//
//    @Resource
//    private CellDemo cellDemo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("inject:" + injectService);
        System.out.println("inject2:" + injectService2);
//        System.out.println(cellDemo);
        System.out.println(map);
    }
}
