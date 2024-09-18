package uni2024.kozub.homework.lab1;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class XmlSerializer<T> implements Serializer<T>{
    private final XmlMapper xmlMapper;

    public XmlSerializer() {
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void serialize(T entity, File file) throws IOException {
        xmlMapper.writeValue(file, entity);
    }

    @Override
    public T deserialize(File file, Class<T> tClass) throws IOException {
        return xmlMapper.readValue(file, tClass);
    }
}
