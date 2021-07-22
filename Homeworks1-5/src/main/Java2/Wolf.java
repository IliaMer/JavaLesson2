package main.Java2;

public class Wolf extends Animals implements Bounceable {

    @Override
    public void run(int speed) {
        System.out.println(getClass().getName() + " " + "бежит со скоростью " + speed + " км/ч");
    }


    @Override
    public void getVoice() {
        System.out.println("Аррррррррр");
    }

    @Override
    public String toString() {
        return "Волчара";
    }

    @Override
    public void move() {
        System.out.println("right");
    }

    @Override
    public void jump() {
        System.out.println(height);
    }
}
