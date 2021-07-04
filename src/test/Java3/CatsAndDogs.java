package test.Java3;
import main.Dog;
import main.Cat;
import java.util.*;

public class CatsAndDogs {

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        cat1.setName("Симпатюлька");
        cat1.setAge(7);
        cat1.setColor("пепельный");
        cat1.setWeight(12);

        Cat cat2 = new Cat();
        cat2.setName("Лентяй");
        cat2.setAge(3);
        cat2.setColor("бело-рыжий");
        cat2.setWeight(11);


        Cat cat3 = new Cat();
        cat3.setName("Леопольд");
        cat3.setAge(4);
        cat3.setColor("черно-белый");
        cat3.setWeight(2);


        List<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat3);


        Set set1 = new HashSet(cats);


        Dog dog1 = new Dog();
        dog1.setName("Коротыш");
        dog1.setAge(6);
        dog1.setWeight(53);

        Dog dog2 = new Dog();
        dog2.setName("Майло");
        dog2.setAge(6);
        dog2.setWeight(23);


        Dog dog3 = new Dog();
        dog3.setName("Чин");
        dog3.setAge(2);
        dog3.setWeight(15);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog3);
        dogs.add(dog3);
        dogs.add(dog3);
        dogs.add(dog3);
        dogs.add(dog3);
        dogs.add(dog3);
        dogs.add(dog3);
        dogs.add(dog3);

        Set set2 = new HashSet(dogs);

        Map map = new HashMap();
        map.put("Собака1", dog1);
        map.put("Собака2", dog2);
        map.put("Собака3", dog3);
        map.put("Кошечка1", cat1);
        map.put("Кошечка2", cat2);
        map.put("Кошечка3", cat3);


        System.out.println(map.get("Собака1"));


    }

}