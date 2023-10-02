package structural.adapter;

import structural.chicken_food.ChickenFeedType;

public class Chicken implements ChickenAbilities {
    private ChickenFeedType chickenFeedType;
    private int price;

    public Chicken(ChickenFeedType chickenFeedType, int price) {
        this.chickenFeedType = chickenFeedType;
        this.price = price;
    }


    public void fly() {
        System.out.println("It can fly!!!");
    }

    @Override
    public int displayFinalPrice() {
        return price + chickenFeedType.additionPrice();
    }
}
