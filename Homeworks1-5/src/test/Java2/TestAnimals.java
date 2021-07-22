package test.Java2;

import main.Java2.Monkey;
import main.Java2.Wolf;

public class TestAnimals {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        Monkey monkey = new Monkey();
        wolf.run(10);
        monkey.getVoice();
        wolf.getVoice();
        wolf.eat();
        monkey.eat();
        wolf.jump();
        wolf.move();
        monkey.move();
    }
}
