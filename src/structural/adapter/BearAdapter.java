package structural.adapter;

import structural.bear.Bear;

public class BearAdapter implements ChickenAbilities {
    Bear bear;
    public BearAdapter(Bear bear) {
        this.bear = bear;
    }

    public void fly()
    {
        bear.run();
    }

    @Override
    public int displayFinalPrice() {
        return bear.finalPrice();
    }
}
