package com.example.subdemo.spring.injection;

import org.springframework.stereotype.Service;

@Service
public class DependsOnServiceImpl implements DependsOnService{

    public DependsOnServiceImpl() {
        System.out.println("DependsOnServiceImpl construct invoked");
    }
}
