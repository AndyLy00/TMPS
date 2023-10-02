package behavioral.strategy;

public class Parrot {

    private String name;
    private int price;

    public Parrot(String name, int cost){
        this.name =name;
        this.price=cost;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
