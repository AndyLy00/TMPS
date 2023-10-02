package behavioral.iterator;

import behavioral.strategy.Parrot;

public class ParrotCart {
    ParrotCollection parrotCollection;
    public ParrotCart(ParrotCollection parrotCollection) {
        this.parrotCollection = parrotCollection;
    }

    public void printItemsPrices() {
        Iterator iterator = parrotCollection.createIterator();
        while (iterator.hasNext()) {
            Parrot n = (Parrot) iterator.next();
            System.out.println(n.getPrice());
        }
    }
}
