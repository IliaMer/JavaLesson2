package test.Java3;
import main.Dog;
import main.Cat;
import java.util.*;

public class CatsAndDogs {

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        cat1.setName("Вася");
        cat1.setAge(5);
        cat1.setColor("белый");
        cat1.setWeight(15);

        Cat cat2 = new Cat();
        cat2.setName("Ион");
        cat2.setAge(2);
        cat2.setColor("коричневый");
        cat2.setWeight(10);


        Cat cat3 = new Cat();
        cat3.setName("Лео");
        cat3.setAge(3);
        cat3.setColor("чёрный");
        cat3.setWeight(8);


        List<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat3);
        cats.add(cat3);
        cats.add(cat3);
        cats.add(cat3);
        cats.add(cat3);


        Set set1 = new HashSet(cats);


        Dog dog1 = new Dog();
        dog1.setName("Шарик");
        dog1.setAge(3);
        dog1.setWeight(45);

        Dog dog2 = new Dog();
        dog2.setName("Руру");
        dog2.setAge(4);
        dog2.setWeight(12);


        Dog dog3 = new Dog();
        dog3.setName("Пёся");
        dog3.setAge(5);
        dog3.setWeight(25);

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
        map.put("Кошка1", cat1);
        map.put("Кошка2", cat2);
        map.put("Кошка3", cat3);


        System.out.println(map.get("Собака1"));


    }

}