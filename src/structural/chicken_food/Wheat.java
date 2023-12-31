package structural.chicken_food;

public class Wheat extends ChickenFeedType {
    public Wheat(ChickenFeed c, int price) {
        super(c);
        this.price = price;
    }

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int additionPrice() {
        return chickenFeed.additionPrice() + price;
    }

}