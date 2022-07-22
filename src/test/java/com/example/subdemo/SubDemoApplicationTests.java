package com.example.subdemo;

import com.example.subdemo.config.AppConfig;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SubDemoApplication.class)
@RunWith(SpringRunner.class)
class SubDemoApplicationTests {

    @Resource
    private AppConfig appConfig;

    @Test
    void contextLoads() {
        System.out.println(appConfig.getApp());
    }

}
