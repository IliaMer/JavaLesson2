import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;


public class UserTests {

    final String FULLNAME_REGEXP = "^[A-Z][a-z]{6,}";
    final String LOGIN_REGEXP = "\"^.{2,6}$\"";

    @Test
    void testInvalidUserFullName() {
        FullName fullName = new FullName("Rakov", "safokls", "2321");
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
        Assertions.assertEquals(6, user.getLogin().length());
        Assertions.assertFalse(user.getLogin().matches(LOGIN_REGEXP));
    }

    @Test
    void  testPassword(){
        User user = new User();
        Assertions.assertFalse(user.getPassword().isEmpty());
        Assertions.assertEquals(10, user.getPassword().length());
        Assertions.assertFalse(user.getPassword().matches(LOGIN_REGEXP));
    }

    @Test
    void testregistrationDate() {
        User user = new User();
        Assertions.assertNotNull(user.getRegistrationDate());
    }

    @Test
    void testbirthday() {
        User user = new User();
        Assertions.assertNotNull(user.getBirthDay());
        Assertions.assertFalse(user.getPassword().matches("yyyy-MM-dd"));
    }
}
