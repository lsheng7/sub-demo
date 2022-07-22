package com.example.subdemo.generic;

import org.springframework.stereotype.Service;

@Service
public class GenericIntegerServiceImpl implements GenericService<IntegerDto, IntegerVo> {

    public BaseVo method(BaseDto BaseDto) {
        System.out.println("com.example.subdemo.generic.GenericIntegerServiceImpl.method");
        return new IntegerVo();
    }
}
