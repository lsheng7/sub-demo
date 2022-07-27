package com.example.subdemo.validator;

import cn.hutool.core.lang.Validator;
import cn.hutool.extra.validation.ValidationUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidatorDemo {

    public static void main(String[] args) {

        log.info("{}", Validator.isEmail("lvsheng359@126.com"));
        UserDto userDto = new UserDto().setSex("s");
        ValidationUtil.validate(userDto).forEach(constraint -> {
            log.info("-----------------------------info--------------------------------------");
            log.info(constraint.getMessage());
            log.info("-----------------------------info--------------------------------------");
        });
        log.info("-------------------------------------------------------------------");
        ValidationUtil.validateProperty(userDto, "sex").forEach(constraint -> log.info("message:{}", constraint.getMessage()));
    }
}
