package com.flint.weather.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Json {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T parse(Object obj, Class<T> t){
        try {
            String json = objectMapper.writeValueAsString(obj);
            return objectMapper.readValue(json, t);
        } catch (JsonProcessingException e) {
            log.error("Error parse json object");
            throw new RuntimeException(e);
        }
    }
}
