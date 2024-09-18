package uni2024.kozub.homework.lab1;

import java.io.File;
import java.io.IOException;

public interface Serializer<T> {
    void serialize(T entity, File file) throws IOException;

    T deserialize(File file, Class<T> tClass) throws IOException;
}
