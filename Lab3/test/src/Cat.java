import java.util.*;


abstract class Animal {}

public class Cat extends Animal{
    String name;

    private static Cat renameCat(Cat cat) {
        System.out.print(cat.name);
        cat = new Cat();
        cat.name = "Mia";
        return cat;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println("Thread 1")).start();
            System.out.println("Thread 0");
        }
    }
}