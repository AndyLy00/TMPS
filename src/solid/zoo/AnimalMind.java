package solid.zoo;

public class AnimalMind {
    private String think;

    public AnimalMind(String think) {
        this.think = think;
    }

    public String getThink() {
        return think;
    }

    public void setThink(String think) {
        this.think = think;
    }

    public void performAction(Movable animal) {
        animal.move();
    }

}
