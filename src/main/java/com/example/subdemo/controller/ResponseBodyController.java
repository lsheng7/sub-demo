package com.example.subdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response/body")
public class ResponseBodyController {


    @GetMapping("/demo")
    public ResponseEntity<Demo> demo() {
        Demo demo = new Demo();
        demo.setName("张三");
        return ResponseEntity.ok(demo);
    }

    public static class Demo {

        private String name;

        public String getAddress() {
            return name.concat(":上海");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
