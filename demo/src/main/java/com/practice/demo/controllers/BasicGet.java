package com.practice.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
public class BasicGet {

    @GetMapping("")
    public ResponseEntity<String> sendHello() {
        return ResponseEntity.ok("Hello world!");
    }
}
