package com.example.subdemo.validator;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/validator")
public class ValidatorController {


    @PostMapping("/user")
    public void create(@Validated @RequestBody  UserDto userDto) {
        System.out.println(userDto);
    }
}
