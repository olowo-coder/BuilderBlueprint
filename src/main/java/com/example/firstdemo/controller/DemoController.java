package com.example.firstdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class DemoController {

    @GetMapping("/app/test")
    public ResponseEntity<?> getResponse(){
        return ResponseEntity.ok(Map.of("message", "yes"));
    }
}
