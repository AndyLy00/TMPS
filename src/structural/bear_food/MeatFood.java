package structural.bear_food;

import java.util.ArrayList;
import java.util.List;

public class MeatFood {
    private int price;

    public MeatFood(int price) {
        this.price = price;
    }

    private List<Meat> meats = new ArrayList<>();

    public void showMeat(int quantity) {
        for(Meat sh : meats) {
            sh.eat(quantity);
        }
    }

    public void add(Meat s){
        this.meats.add(s);
    }

    public int getPrice() {
        return price * meats.size();
    }

    public void clear(){
        System.out.println("Clear meat");
        this.meats.clear();
    }
}
