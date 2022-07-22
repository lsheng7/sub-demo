package com.example.subdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class RedirectAndForwardController {


    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:/login.html";
    }

    @GetMapping("/forward")
    public String forward() {
        return "forward:/login.html";
    }


    @RequestMapping("/normal")
    public String normal() {
        return "/login";
    }
}
