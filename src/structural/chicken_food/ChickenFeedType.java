package structural.chicken_food;

public abstract class ChickenFeedType {
    protected ChickenFeed chickenFeed;

    public ChickenFeedType(ChickenFeed chickenFeed){
        this.chickenFeed = chickenFeed;
    }

    abstract public int additionPrice();
}
