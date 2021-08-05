import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;


public class UserTests {

    final String FULLNAME_REGEXP = "^[A-Z][a-z]*$";
    final String PASSWORD_REGEXP = "(^[a-z]*([A-Z]{1})[a-z]*([0-9]{1})[a-z]*$)|(^[a-z]*([0-9]{1})[a-z]*([A-Z]{1})[a-z]*$)";
    final String BIRTHDATE_REGEXP = "^\\d{4}-\\d{2}-\\d{2}$";

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
        Assertions.assertEquals(User.getLengthLogin(), user.getLogin().length());
    }

    @Test
    void  testPassword(){
        User user = new User();
        Assertions.assertFalse(user.getPassword().isEmpty());
        int length = user.getPassword().length();
        Assertions.assertTrue((User.getMinLengthPassword() <= length) && (length < User.getMaxLengthPassword()));
        Assertions.assertTrue(user.getPassword().matches(PASSWORD_REGEXP));
    }

    @Test
    void testregistrationDate() {
        User user = new User();
        Assertions.assertNotNull(user.getRegistrationDate());
        System.out.println(user);
    }

    @Test
    void testbirthday() {
        User user = new User();
        Assertions.assertNotNull(user.getBirthDay());
        Assertions.assertTrue(user.getBirthDay().matches(BIRTHDATE_REGEXP));
    }
}
