package solid;

import solid.real.Bird;
import solid.real.Dog;
import solid.real.Fish;
import solid.zoo.*;

public class Main {
    public static void main(String[] args) {
        Animal lion = new Animal("Lion");
        AnimalSound animalSound = new AnimalSound();
        animalSound.makeSound(lion);

        Bird sparrow = new Bird();
        Fish shark = new Fish();

        //Liskov Substitution Parintele e inlocuit cu Copilul
        AnimalMind animalAction = new AnimalAction("Action");
        animalAction.performAction(sparrow);
        animalAction.performAction(shark);

        //Interface Segregation
        Eater dog = new Dog();
        dog.eat();

        AnimalManager animalManager = new AnimalManager(new AnimalEatingAction(dog));
        animalManager.executeAction();
    }
}