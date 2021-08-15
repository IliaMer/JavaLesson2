package utils;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLMapperJackson {
    private XmlMapper mapper = new XmlMapper();

    public void deserializer(File file, Class clazz) {
        try {
            mapper.readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializer(File file, Object o) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(file, o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
