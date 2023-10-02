package structural.bear;

import structural.bear_food.MeatFood;

public class BrownBear implements Bear {
    private String name;
    private int age;
    private MeatFood meatFood;

    public BrownBear(String name, int age, MeatFood meatFood) {
        this.name = name;
        this.age = age;
        this.meatFood = meatFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int finalPrice() {
        return getAge() + meatFood.getPrice();
    }

    @Override
    public void run() {
        System.out.println("It can run!");
    }
}
