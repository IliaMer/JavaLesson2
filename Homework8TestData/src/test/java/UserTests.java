import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;


public class UserTests {

    final String FULLNAME_REGEXP = "^[A-Z][a-z]{6,}";

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

}
