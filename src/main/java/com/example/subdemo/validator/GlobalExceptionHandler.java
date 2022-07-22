package com.example.subdemo.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public void handleBusinessException(MethodArgumentNotValidException e) {
        log.error("business exception:code:{}", e.getMessage());
        e.getBindingResult().getFieldErrors().forEach(error -> log.info("error message: {}", error.getDefaultMessage()));
    }

}