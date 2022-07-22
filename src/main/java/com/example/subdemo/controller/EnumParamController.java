package com.example.subdemo.controller;

import com.example.subdemo.enums.EnumTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enum")
public class EnumParamController {

    @GetMapping("/param/{test}")
    public void enumParam(@PathVariable EnumTest test) {
        if (test == EnumTest.TEST) {
            System.out.println(test);
        }
    }
}
