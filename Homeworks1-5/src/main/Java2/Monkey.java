package main.Java2;

public class Monkey extends Animals {

    @Override
    void run(int speed) {

    }

    @Override
    public void getVoice() {
        System.out.println("у-а-а-а-у-у-у");
    }

    @Override
    public String toString() {
        return "Обезьянка";
    }

    @Override
    public void move() {
        System.out.println(direction);
    }
}
