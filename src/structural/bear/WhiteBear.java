package structural.bear;

public class WhiteBear extends BearDecorator {
    private int addAge;

    public WhiteBear(Bear c, int addAge) {
        super(c);
        this.addAge = addAge;
    }

    public int getAddAge() {
        return addAge;
    }

    public void setAddAge(int addAge) {
        this.addAge = addAge;
    }

    @Override
    public int finalPrice() {
        return super.finalPrice() + getAddAge();
    }
}
