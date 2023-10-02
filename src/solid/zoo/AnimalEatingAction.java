package solid.zoo;

public class AnimalEatingAction implements AnimalHabit {
    //dependency inversion
    private Eater eater;

    //constructor (Dependency Injection)
    public AnimalEatingAction(Eater eater) {
        this.eater = eater;
    }

    public void performAction() {
        eater.eat();
    }
}