import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class User implements Serializable {
    private FullName name;
    private String birthDay;
    private LocalDateTime registrationDate;
    private String login;
    private String password;
    private UserAddress address;


    private static int minLengthPassword = 6;
    private static int maxLengthPassword = 10;
    private static int lengthLogin = 6;
    private static int maxAge = 102;

    public User(FullName name, String birthDay, LocalDateTime registrationDate, String login, String password) {
        this.name = name;
        this.birthDay = birthDay;
        this.registrationDate = registrationDate;
        this.login = login;
        this.password = password;
        this.address = address;
    }

    public User() {
        this.name = generateRandomName();
        this.birthDay = generateRandomDate();
        this.registrationDate = generateRandomRegistrationDate();
        this.login = generateRandomLogin();
        this.password = generateRandomPassword();
        this.address = generateRandomUserAddress();
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", birthDay='" + birthDay + '\'' +
                ", registrationDate=" + registrationDate +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }

    private String generateRandomDate() {
        RandomDataGenerator dayDataGenerator = new RandomDataGenerator();
        RandomDataGenerator monthDataGenerator = new RandomDataGenerator();
        RandomDataGenerator yearDataGenerator = new RandomDataGenerator();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int day = dayDataGenerator.nextInt(1, 30);
        int month = monthDataGenerator.nextInt(1, 12);
        int year = yearDataGenerator.nextInt(1918, 2020);

        return dtf.format(LocalDate.of(year, month, day));

    }

    private FullName generateRandomName() {
        String[] firstNames = {"Igorek", "Vasilii", "Romka", "Vitalya"};
        String[] lastNames = {"Bubin", "Zrachkov", "Privetov", "Kryuger"};
        String[] middleNames = {"Petrovich", "Sanich", "Romich", "Vitalich"};
        return new FullName(firstNames[new Random().nextInt(firstNames.length)],
                lastNames[new Random().nextInt(lastNames.length)],
                middleNames[new Random().nextInt(middleNames.length)]);
    }


    private LocalDateTime generateRandomRegistrationDate() {
        return LocalDateTime.now();
    }

    private String generateRandomLogin() {
        return generateRandomAlphanumeric(lengthLogin);
    }

    private String generateRandomPassword() {
        int lengthOfPassword = getRandomNumber(minLengthPassword, maxLengthPassword);
        String digit = RandomStringUtils.randomNumeric(1);
        String upperLetter = RandomStringUtils.randomAlphabetic(1).toUpperCase();
        String lowerLetter = RandomStringUtils.randomAlphabetic(lengthOfPassword - 2).toLowerCase();

        String password = digit + upperLetter + lowerLetter;
        password = shuffle(password);

        return password;
    }

    public String shuffle(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> str = new ArrayList();

        for (char character : chars) {
            str.add(character);
        }

        Collections.shuffle(str);
        return StringUtils.join(str.toArray());
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private String generateRandomAlphanumeric(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    private UserAddress generateRandomUserAddress() {
        String[] city = {"Sevastopol", "Innopolis", "Moscow", "Piter", "London", "Kazan"};
        String[] street = {"Prospekt Pobedi", "Proletarskaya", "Lenina", "Ushakova", "Nakhimova"};
        String[] houseNumber = {"33", "2", "12", "54", "21", "54", "99"};
        String[] apartmentNumber = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        return new UserAddress(city[new Random().nextInt(city.length)],
                street[new Random().nextInt(street.length)],
                houseNumber[new Random().nextInt(houseNumber.length)],
                apartmentNumber[new Random().nextInt(apartmentNumber.length)]);
    }


    public FullName getName() {
        return name;
    }

    public String getBirthDay() {
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

    public UserAddress getAddress() {
        return address;
    }

    public static int getMinLengthPassword() {
        return minLengthPassword;
    }

    public static void setMinLengthPassword(int minLengthPassword) {
        User.minLengthPassword = minLengthPassword;
    }

    public static int getMaxLengthPassword() {
        return maxLengthPassword;
    }

    public static void setMaxLengthPassword(int maxLengthPassword) {
        User.maxLengthPassword = maxLengthPassword;
    }

    public static int getLengthLogin() {
        return lengthLogin;
    }

    public static void setLengthLogin(int lengthLogin) {
        User.lengthLogin = lengthLogin;
    }

    public static int getMaxAge() {
        return maxAge;
    }

    public static void setMaxAge(int maxAge) {
        User.maxAge = maxAge;
    }
}
