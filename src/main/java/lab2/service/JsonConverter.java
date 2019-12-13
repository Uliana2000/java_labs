package lab2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab2.exception.ConvertException;

public class JsonConverter<T> implements Converter<T> {

    private Class<T> typeOfClass;
    private ObjectMapper mapper;

    {
        mapper = new ObjectMapper();
    }

    public JsonConverter(Class<T> typeOfClass) {
        this.typeOfClass = typeOfClass;
    }

    @Override
    public String serializeToString(T obj) throws ConvertException {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

    @Override
    public T deserializeString(String str) throws ConvertException {
        try {
            return mapper.readValue(str, typeOfClass);
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }
}