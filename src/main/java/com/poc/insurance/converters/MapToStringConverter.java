package com.poc.insurance.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.HashMap;

@Converter
public class MapToStringConverter implements AttributeConverter<HashMap<String, Object>, String> {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(HashMap<String, Object> data) {
        String value = "";
        try {
            value = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public HashMap<String, Object> convertToEntityAttribute(String data) {
        HashMap<String, Object> mapValue = new HashMap<>();
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<>() {
        };
        try {
            mapValue = mapper.readValue(data, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapValue;
    }

}
