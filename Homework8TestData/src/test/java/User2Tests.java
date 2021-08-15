import org.junit.jupiter.api.Test;
import utils.JSONMapperJackson;
import utils.XMLMapperJackson;
import utils.XMLMapperJavaxXml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        //xmlMapperJackson.deserializer(new File(String.valueOf(path)), User.class);
        xmlMapperJackson.serializer(new File(String.valueOf(path2)), user);
        //System.out.println(user);

    }

    @Test
    void JsonMappers() {
        User user = new User();
        Path path = Paths.get("C:\\Merzliak\\JavaLessons\\Homework8TestData\\src\\target\\testJson.json");
        JSONMapperJackson mapperJackson = new JSONMapperJackson();
        //mapperJackson.serializeJson(new File(String.valueOf(path)), user);
        mapperJackson.deserializeJson(new File(String.valueOf(path)), User.class);
        System.out.println(user);
    }
}
