package test.Java1;

import main.Java1.Parrot;

public class TestParrot {

    public static void main(String[] args) {
        Parrot jaco1 = new Parrot();

        jaco1.name = "Гришаня";
        jaco1.color = "Пепельно-серый";
        jaco1.length = 40;
        jaco1.wingspan = 22;
        jaco1.weight = 550.0;


        Parrot jaco2 = new Parrot();

        jaco2.name = "Игорёк";
        jaco2.color = "Пурпурно-красный";
        jaco2.length = 45;
        jaco2.wingspan = 20;
        jaco2.weight = 600.0;

        System.out.println("Первый попугай " + jaco1.name + ", раскрас у него " + jaco1.color + ", весит он " + jaco1.weight + ", его длина " + jaco1.length + ", а размах крыльев " + jaco1.wingspan);
        System.out.println("Второй попугай " + jaco2.name + ", раскрас у него " + jaco2.color + ", весит он " + jaco2.weight + ", его длина " + jaco2.length + ", а размах крыльев " + jaco2.wingspan);

        jaco1.talk();
        jaco1.eat();
        jaco2.sleep();
        jaco2.fly();

    }

}
