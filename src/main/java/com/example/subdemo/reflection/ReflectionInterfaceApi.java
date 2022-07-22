package com.example.subdemo.reflection;

import com.example.subdemo.mbp.service.AreaServiceImpl;
import java.util.Arrays;

public class ReflectionInterfaceApi {

    public static void main(String[] args) {
        Arrays.asList(AreaServiceImpl.class.getInterfaces()).forEach(clazz -> System.out.println(clazz.getName()));
    }
}
