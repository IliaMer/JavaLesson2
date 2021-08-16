import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import utils.JSONMapperJackson;
import utils.XMLMapperJackson;
import utils.XMLMapperJavaxXml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User2Tests {

    @Test
    void XMLMappers() throws IOException {
        User user = new User();
        Path path = Paths.get("C:\\Merzliak\\JavaLessons\\Homework8TestData\\src\\target\\testXml.xml");
        Path path2 = Paths.get("C:\\Merzliak\\JavaLessons\\Homework8TestData\\src\\target\\testXml2.xml");
        XMLMapperJavaxXml mapperJavaxXml = new XMLMapperJavaxXml(User.class);
        XMLMapperJackson xmlMapperJackson = new XMLMapperJackson();
        /*FileWriter writer = new FileWriter(String.valueOf(path));
        mapperJavaxXml.marshall(user, writer);
        writer.flush();
        writer.close();

        mapperJavaxXml.unmarshall(new FileReader(String.valueOf(path)));*/

        xmlMapperJackson.deserializer(new File(String.valueOf(path)), Object.class);
//        xmlMapperJackson.serializer(new File(String.valueOf(path2)), user);
        System.out.println(user);

    }

    @Test
    void JsonMappers() {
        User user = new User();
        Path path = Paths.get("C:\\Merzliak\\JavaLessons\\Homework8TestData\\src\\target\\testJson.json");
        JSONMapperJackson mapperJackson = new JSONMapperJackson();
        mapperJackson.serializeJson(new File(String.valueOf(path)), user);
//        mapperJackson.deserializeJson(new File(String.valueOf(path)), Object.class);
        System.out.println(user);
    }

    @Test
    void JsonMappersGSONWriter() throws IOException {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            users.add(user);
        }
        Path path = Paths.get("C:\\Merzliak\\JavaLessons\\Homework8TestData\\src\\target\\testJsonGSON.json");
        Gson gson = new Gson();
        FileWriter writer = new FileWriter(String.valueOf(path));
        gson.toJson(users, writer);
        writer.flush();
        writer.close();
    }

    @Test
    void JsonMappersGSONReader() throws IOException {
        Path path = Paths.get("C:\\Merzliak\\JavaLessons\\Homework8TestData\\src\\target\\testJsonGSON.json");
        Gson gson = new Gson();
        FileReader reader = new FileReader(String.valueOf(path));
        User[] users = gson.fromJson(reader, User[].class);
        System.out.println(Arrays.toString(users));
        System.out.println(users.length);
    }
}
