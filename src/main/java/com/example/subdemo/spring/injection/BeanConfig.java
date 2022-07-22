package com.example.subdemo.spring.injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public BeanDemo beanDemo() {
        return new BeanDemo();
    }
}
