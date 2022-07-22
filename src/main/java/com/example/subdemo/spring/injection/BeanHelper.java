package com.example.subdemo.spring.injection;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class BeanHelper {

    @Resource
    private DependsOnService dependsOnService;
}
