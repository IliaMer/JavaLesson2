package main;

public class Dog {
    public static String name;
    public int age;
    public double weight;

    public void bark() {
    }

    public void giveAPaw() {
    }

    public void run() {
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Dog.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}