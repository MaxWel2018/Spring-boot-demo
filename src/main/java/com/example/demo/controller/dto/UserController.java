package com.example.demo.controller.dto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class UserController {
    @GetMapping
    public String hello() {
        return "Hello world";
    }
}
