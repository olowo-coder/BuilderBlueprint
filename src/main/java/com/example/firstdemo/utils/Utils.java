package com.example.firstdemo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@Slf4j
public class Utils {

    public String requestToString(Object data){
        ObjectMapper mapper = new ObjectMapper();
        String jsonToString = null;
        try{
            jsonToString = mapper.writeValueAsString(data);
        }catch (JsonProcessingException e) {
            log.info("Unable to to process {}", data);
        }
        return jsonToString;
    }

    public Object stringToJson(String stringData){
        ObjectMapper mapper = new ObjectMapper();
        Object obj = null;
        try{
//            if(stringData.equals("null")) return null;
            obj = mapper.readValue(stringData, Object.class);
        }catch (JsonProcessingException e) {
            log.info("Unable to to process {}", stringData);
        }
        return obj;
    }

    public JsonObject stringToGson(String stringData){
        JsonObject convertedObject = new Gson().fromJson(stringData, JsonObject.class);

        Gson gson = new Gson();
        return gson.fromJson(stringData, JsonObject.class);
    }

    public LocalDateTime stringToDateTime(String stringData){
        LocalDateTime out = LocalDateTime.parse(stringData);
        return out;
    }

    public static String getCurrentDate(){
        return new Date().toString();
    }
}
