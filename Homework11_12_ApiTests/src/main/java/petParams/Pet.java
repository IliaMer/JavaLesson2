package petParams;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Random;

public class Pet {
    private Long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tags[] tags;
    private String status;

    public Pet() {
        this.id = new Random().nextLong();
        this.category = new Category();
        this.name = RandomStringUtils.randomAlphabetic(10);
        this.photoUrls = new String[2];
        this.tags = new Tags[]{new Tags()};
        this.status = "available";
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Tags[] getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + Arrays.toString(photoUrls) +
                ", tags=" + Arrays.toString(tags) +
                ", status='" + status + '\'' +
                '}';
    }
}
