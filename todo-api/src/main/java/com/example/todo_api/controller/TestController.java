package com.example.todo_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String welcome() {
        return "Hello World";
    }

    @GetMapping(value = "/health/checker")
    public String healthChecker() {
        return "success";
    }
}
