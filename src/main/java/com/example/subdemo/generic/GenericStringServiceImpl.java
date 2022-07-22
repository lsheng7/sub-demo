package com.example.subdemo.generic;

import org.springframework.stereotype.Service;

@Service
public class GenericStringServiceImpl implements GenericService<StringDto, StringVo> {

    @Override
    public BaseVo method(BaseDto baseDto) {
        System.out.println("com.example.subdemo.generic.GenericStringServiceImpl.method");
        return null;
    }
}
