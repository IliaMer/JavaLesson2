package main.Java2;

public abstract class Animals implements Moveable {

    private String name;
    private int age;


    abstract void run(int speed);

    abstract void getVoice();

    public void eat() {
        System.out.println("ням-ням " + toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
