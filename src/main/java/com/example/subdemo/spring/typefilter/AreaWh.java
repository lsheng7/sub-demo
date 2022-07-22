package com.example.subdemo.spring.typefilter;

import org.springframework.stereotype.Component;

@Areaed("wh")
@Component("area")
public class AreaWh implements IArea {

    @Override
    public void say() {
        System.out.println("武汉");
    }
}
