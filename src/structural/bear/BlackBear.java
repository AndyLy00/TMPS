package structural.bear;

public class BlackBear extends BearDecorator {

    private int addPrice;

    public BlackBear(Bear c, int addPrice) {
        super(c);
        this.addPrice = addPrice;
    }

    public int getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(int addPrice) {
        this.addPrice = addPrice;
    }

    @Override
    public int finalPrice(){
        return super.finalPrice() + getAddPrice();
    }
}
