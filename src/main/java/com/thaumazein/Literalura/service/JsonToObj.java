package com.thaumazein.Literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.function.Function;

public class JsonToObj implements IJsonToObj {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convert(String json, Class<T> obj) {
        try{
            return mapper.readValue(json, obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
