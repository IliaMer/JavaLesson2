import org.apache.commons.lang3.RandomStringUtils;

import javax.naming.Name;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private String name;
    private Date birthDay;
    private LocalDateTime registrationDate;
    private String login;
    private String password;

    public User(String name, Date birthDay, LocalDateTime registrationDate, String login, String password) {
        this.name = name;
        this.birthDay = birthDay;
        this.registrationDate = registrationDate;
        this.login = login;
        this.password = password;
    }

    public User() {
        this.name = generateRandomName();
        this.birthDay = generateRandomDate();
        this.registrationDate = generateRandomRegistrationDate();
        this.login = generateRandomLogin(6);
        this.password = generateRandomPassword(10);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", registrationDate=" + registrationDate +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private Date generateRandomDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            return sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    private String generateRandomName() {
        String firstName = "";
        String lastName = "";
        String middleName = "";
        return new FullName(lastName, firstName, middleName).getNameStr();
    }

    private String generateRandomName(FullName fullName) {
        return fullName.getLastName() + " " + fullName.getFirstName() + "." + fullName.getMiddleName();
    }

    private LocalDateTime generateRandomRegistrationDate() {
        return LocalDateTime.now();
    }

    private String generateRandomLogin(int count) {
        return generateRandomAlphanumeric(count);
    }

    private String generateRandomPassword(int count) {
        return generateRandomAlphanumeric(count);
    }

    private String generateRandomAlphanumeric(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public String getName() {
        return name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
