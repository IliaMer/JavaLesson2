import org.apache.commons.lang3.RandomStringUtils;

import javax.naming.Name;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class User {
    private FullName name;
    private Date birthDay;
    private LocalDateTime registrationDate;
    private String login;
    private String password;

    public User(FullName name, Date birthDay, LocalDateTime registrationDate, String login, String password) {
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

    private FullName generateRandomName() {
        String[] firstNames = {"Igorek", "Vasilii", "Romka", "Vitalya"};
        String[] lastNames = {"Igorek", "Vasilii", "Romka", "Vitalya"};
        String[] middleNames = {"Igorek", "Vasilii", "Romka", "Vitalya"};
        return new FullName (firstNames[new Random().nextInt(firstNames.length)], lastNames[new Random().nextInt(lastNames.length)],middleNames [new Random().nextInt(middleNames.length)]);
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

    public FullName getName() {
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
