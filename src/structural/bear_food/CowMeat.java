package structural.bear_food;

public class CowMeat implements Meat {
    @Override
    public void eat(int quantity) {
            System.out.println("Cow meat " + quantity);
    }

}
