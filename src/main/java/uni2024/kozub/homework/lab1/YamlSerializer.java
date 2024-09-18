package uni2024.kozub.homework.lab1;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class YamlSerializer<T> implements Serializer<T>{
    private final YAMLMapper yamlMapper;

    public YamlSerializer() {
        this.yamlMapper = new YAMLMapper();
        this.yamlMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void serialize(T entity, File file) throws IOException {
        yamlMapper.writeValue(file, entity);
    }

    @Override
    public T deserialize(File file, Class<T> tClass) throws IOException {
        return yamlMapper.readValue(file, tClass);
    }
}
