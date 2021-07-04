package main;

public class Cat {
    public static String name;
    public static int age;
    public static String color;
    public static int weight;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Cat.name = name;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Cat.age = age;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        Cat.color = color;
    }

    public static int getWeight() {
        return weight;
    }

    public static void setWeight(int weight) {
        Cat.weight = weight;
    }
}