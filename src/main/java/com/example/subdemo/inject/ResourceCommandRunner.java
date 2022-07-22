package com.example.subdemo.inject;

import javax.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ResourceCommandRunner implements ApplicationRunner {

    @Resource
    private ResourceInterface resource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(resource);
    }
}
