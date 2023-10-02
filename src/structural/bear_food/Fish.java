package structural.bear_food;

public class Fish implements Meat {

    @Override
    public void eat(int quantity) {
        System.out.println("Fish Meat " + quantity);
    }

}
