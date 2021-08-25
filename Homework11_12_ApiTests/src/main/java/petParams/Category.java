package petParams;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Category {
    private Long id;
    private String name;

    public Category() {
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
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
