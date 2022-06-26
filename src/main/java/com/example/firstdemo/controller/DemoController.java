package com.example.firstdemo.controller;

import com.example.firstdemo.dto.LoanResponse;
import com.example.firstdemo.dto.RequestEnquiryDto;
import com.example.firstdemo.mappers.MapStructMapper;
import com.example.firstdemo.utils.Utils;
import com.example.firstdemo.dto.LoanRequest;
import com.example.firstdemo.dto.UserDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class DemoController {

    private final Utils utils;

    private final ModelMapper modelMapper;

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
        return ResponseEntity.ok(Map.of("validated", MapStructMapper.MAPPER.loanRequestToLoanResponse(request),
                "time", LocalDate.now().toString()));
    }

    @PostMapping("/app/mapper")
    public ResponseEntity<?> jsonMapper(@RequestBody final @Valid LoanRequest request){
        String json = utils.requestToString(request);
        LoanResponse response = new LoanResponse(json);
        System.out.println(response);
        JsonObject dataToStringVal = utils.stringToGson(json);
//        System.out.println(dataToStringVal);
//        System.out.println("JsonObject ==>");
//        System.out.println(dataToStringVal.get("loanId"));
        return ResponseEntity.ok(dataToStringVal);
    }

    @PostMapping("/app/dateformat")
    public ResponseEntity<?> localDateFormat(@RequestBody final @Valid LoanRequest request){
        String json = utils.requestToString(request);
        JsonObject dataToStringVal = utils.stringToGson(json);
        System.out.println(dataToStringVal);

        return ResponseEntity.ok("dataToStringVal");
    }
}
