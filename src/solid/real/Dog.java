package solid.real;

import solid.zoo.Eater;
import solid.zoo.Sleeper;

public class Dog implements Eater, Sleeper {
    public void eat() {
        System.out.println("Dog eats.");
    }

    public void sleep() {
        System.out.println("Dog sleeps.");
    }
}