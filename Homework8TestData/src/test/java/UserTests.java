import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;


public class UserTests {

    @Test
    void defaultUser() {
        User user = new User();
        FullName fullName = new FullName("", "", "");
        Assertions.assertTrue(user.toString().contains(fullName.getNameStr()));
    }

    @Test
    void customUser() {
        String name = "fio";
        String login = "login";
        String pass = "pass";
        Date dateUser = new Date();
        LocalDateTime localDateTimeUser = LocalDateTime.now();

        User user = new User(name,dateUser,localDateTimeUser,login,pass);

        Assertions.assertEquals(user.getName(),name);
        Assertions.assertEquals(user.getBirthDay(),dateUser);
        Assertions.assertEquals(user.getRegistrationDate(),localDateTimeUser);
        Assertions.assertEquals(user.getLogin(),login);
        Assertions.assertEquals(user.getPassword(),pass);
    }
}
