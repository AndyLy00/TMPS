package structural.chicken_food;

public class Corn extends ChickenFeedType {
    private int price;
    public Corn(ChickenFeed c, int price) {
        super(c);
        this.price = price;
    }

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