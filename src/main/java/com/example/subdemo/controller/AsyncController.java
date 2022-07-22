package com.example.subdemo.controller;

import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {

    @GetMapping
    public String task() {

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10_000L);
                log.info("async task complete");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return "success";
    }
}
