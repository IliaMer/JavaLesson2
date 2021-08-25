package petParams;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Tags {
    private Long id;
    private String name;

    public Tags() {
        this.id = new Random().nextLong();
        this.name = RandomStringUtils.randomAlphabetic(10);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
