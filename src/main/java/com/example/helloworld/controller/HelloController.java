package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "DraftLab Spring Server is running!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, DraftLab!";
    }
}
