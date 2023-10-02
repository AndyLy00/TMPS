package structural.bear;

public class BearDecorator implements Bear {
    protected Bear bear;

    public BearDecorator(Bear c) {
        this.bear = c;
    }

    @Override
    public void run() {
        System.out.println("It cam run!");
    }

    @Override
    public int finalPrice() {
        return this.bear.finalPrice();
    }

}
