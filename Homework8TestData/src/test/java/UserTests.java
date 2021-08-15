import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.XMLMapperJackson;
import utils.XMLMapperJavaxXml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserTests {

    final String FULLNAME_REGEXP = "^[A-Z][a-z]*$";
    final String PASSWORD_REGEXP = "(^[a-z]*([A-Z]{1})[a-z]*([0-9]{1})[a-z]*$)|(^[a-z]*([0-9]{1})[a-z]*([A-Z]{1})[a-z]*$)";
    final String BIRTHDATE_REGEXP = "^\\d{4}-\\d{2}-\\d{2}$";

    @Test
    void testInvalidUserFullName() {
        FullName fullName = new FullName("532", "ls", "2321");
        Assertions.assertFalse(fullName.getFirstName().matches(FULLNAME_REGEXP));
        Assertions.assertFalse(fullName.getLastName().matches(FULLNAME_REGEXP));
        Assertions.assertFalse(fullName.getMiddleName().matches(FULLNAME_REGEXP));

    }

    @Test
    void testGeneratedFullName() {
        User user = new User();
        Assertions.assertTrue(user.getName().getFirstName().matches(FULLNAME_REGEXP));
        Assertions.assertTrue(user.getName().getLastName().matches(FULLNAME_REGEXP));
        Assertions.assertTrue(user.getName().getMiddleName().matches(FULLNAME_REGEXP));
    }


    @Test
    void testLogin() {
        User user = new User();
        Assertions.assertFalse(user.getLogin().isEmpty());
        Assertions.assertEquals(User.getLengthLogin(), user.getLogin().length());
    }

    @Test
    void testPassword() {
        User user = new User();
        Assertions.assertFalse(user.getPassword().isEmpty());
        int length = user.getPassword().length();
        Assertions.assertTrue((User.getMinLengthPassword() <= length) && (length < User.getMaxLengthPassword()));
        Assertions.assertTrue(user.getPassword().matches(PASSWORD_REGEXP));
    }

    @Test
    void testRegistrationDate() {
        User user = new User();
        Assertions.assertNotNull(user.getRegistrationDate());
        System.out.println(user);
    }

    @Test
    void testBirthday() {
        User user = new User();
        Assertions.assertNotNull(user.getBirthDay());
        Assertions.assertTrue(user.getBirthDay().matches(BIRTHDATE_REGEXP));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(user.getBirthDay(), dtf);
        date = date.plusYears(User.getMaxAge());
        Assertions.assertTrue(date.isAfter(LocalDate.now()));
    }

    @Test
    void testUserWriter() {
        Path path = Paths.get("C:\\Merzliak\\JavaLessons\\Homework8TestData\\users.txt");
        ArrayList<User> userData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            userData.add(user);
        }
        Writer.writeObjectsToFile(path, Collections.singletonList(userData));
        try {
            System.out.println(Files.readAllLines(Paths.get("users.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testUserAddressesWriter() throws IOException, ClassNotFoundException {
        Path pathUsers = Paths.get("C:\\Merzliak\\JavaLessons\\Homework8TestData\\src\\target\\usersByte.txt");
        Path pathAddresses = Paths.get("C:\\Merzliak\\JavaLessons\\Homework8TestData\\src\\target\\addresses.txt");
        ArrayList<User> userData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            userData.add(user);
        }
        Writer.writeBytesToFile(pathUsers, Collections.singletonList(userData));
        List<UserAddress> addresses = Reader.readBytesAddresses(pathUsers);
        Writer.writeObjectsToFile(pathAddresses, Collections.singletonList(addresses));
        try {
            System.out.println(Files.readAllLines(pathAddresses));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
