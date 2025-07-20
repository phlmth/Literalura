package xyz.thaumazein.literalura.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter implements IJsonConverter {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convert(String json, Class<T> cls) {
        try {
            return mapper.readValue(json, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
