package com.example.subdemo.spring.typefilter;

import org.springframework.stereotype.Component;

@Areaed("nx")
@Component("area")
public class AreaNx implements IArea {

    @Override
    public void say() {
        System.out.println("宁夏");
    }
}
