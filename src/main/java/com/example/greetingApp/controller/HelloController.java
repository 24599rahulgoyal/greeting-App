package com.example.greetingApp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Hello API", description = "Simple API to test Swagger integration")
public class HelloController {

    @GetMapping("/hello")
    @Operation(summary = "Returns a greeting message", description = "This API returns a simple hello message to test Swagger.")
    public String sayHello() {
        return "Hello, Swagger is working!";
    }
}