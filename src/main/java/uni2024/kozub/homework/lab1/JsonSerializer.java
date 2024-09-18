package uni2024.kozub.homework.lab1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class JsonSerializer<T> implements Serializer<T>{

    private final ObjectMapper objectMapper;

    public JsonSerializer() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void serialize(T entity, File file) throws IOException {
        objectMapper.writeValue(file, entity);
    }

    @Override
    public T deserialize(File file, Class<T> tClass) throws IOException {
        return objectMapper.readValue(file, tClass);
    }
}
