package com.example.firstdemo.controller;

import com.example.firstdemo.dto.LoanRequest;
import com.example.firstdemo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;


@RestController
public class DemoController {

    @GetMapping("/app/test")
    public ResponseEntity<?> getResponse(){

        return ResponseEntity.ok(Map.of("message", new UserDto.Builder()
                .firstName("Ben").lastName("Mike").age(40).address("silver street")
                .build()));
    }

    @PostMapping("/app/generate")
    public ResponseEntity<?> deserialize(@RequestBody final UserDto userDto){
        System.out.println(userDto);
        userDto.setAge(900);
        return ResponseEntity.ok(Map.of("generated", userDto));
    }

    @PostMapping("/app/validate")
    public ResponseEntity<?> validator(@RequestBody final @Valid LoanRequest request){
        System.out.println(request);
        return ResponseEntity.ok(Map.of("validated", request));
    }
}
