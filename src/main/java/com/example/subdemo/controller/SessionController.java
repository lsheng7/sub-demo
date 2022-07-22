package com.example.subdemo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Resource
    private HttpServletRequest request;

    @GetMapping("/get/id")
    public void getSessionId() {
        System.out.println(request.getSession().getId());
    }
}
