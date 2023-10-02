package solid.zoo;

public class AnimalManager {
    private AnimalHabit animalHabit;

    public AnimalManager(AnimalHabit animalHabit) {
        this.animalHabit = animalHabit;
    }

    public void executeAction() {
        animalHabit.performAction();
    }
}