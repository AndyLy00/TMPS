package structural;

import structural.adapter.Chicken;
import structural.adapter.ChickenAbilities;
import structural.adapter.BearAdapter;
import structural.chicken_food.*;
import structural.bear.Bear;
import structural.bear.BlackBear;
import structural.bear.WhiteBear;
import structural.bear.BrownBear;
import structural.bear_food.Fish;
import structural.bear_food.Meat;
import structural.bear_food.MeatFood;
import structural.bear_food.CowMeat;

public class Main {
    public static void main(String[] args) {
        //Bridge
        ChickenFeedType chickenFeedType = new Wheat(new DirtFeed(), 100);
        chickenFeedType.additionPrice();

        ChickenFeedType chickenFeedType1 = new Corn(new ClearFeed(), 200);
        chickenFeedType1.additionPrice();

        //Composite
        Meat fish = new Fish();
        Meat fish1 = new Fish();
        Meat cowMeat = new CowMeat();
        MeatFood meatFood = new MeatFood(100);
        meatFood.add(fish1);
        meatFood.add(fish1);
        meatFood.add(cowMeat);
        meatFood.showMeat(50);
        meatFood.clear();
        meatFood.add(fish);
        meatFood.add(cowMeat);
        meatFood.showMeat(20);

//        Decorator
        Bear whiteBear = new WhiteBear(new BrownBear("Po", 5, meatFood), 10);
        System.out.println(whiteBear.finalPrice());

        Bear whiteBear1 = new WhiteBear(new BlackBear(new BrownBear("Dave", 3, meatFood), 30), 20);
        System.out.println(whiteBear1.finalPrice());

//        Adapter
        ChickenAbilities chickenAbilities = new Chicken(chickenFeedType1, 100);
        ChickenAbilities bearAdapter = new BearAdapter(whiteBear);
        System.out.println(chickenAbilities.displayFinalPrice());
        bearAdapter.fly();
    }
}
