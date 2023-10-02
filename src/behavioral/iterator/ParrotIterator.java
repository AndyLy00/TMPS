package behavioral.iterator;

import behavioral.strategy.Parrot;

public class ParrotIterator implements Iterator {
    Parrot[] parrots;

    int pos = 0;

    public ParrotIterator(Parrot[] parrots) {
        this.parrots = parrots;
    }

    public Object next() {
        // return next element in the array and increment pos
        Parrot parrot = parrots[pos];
        pos += 1;
        return parrot;
    }

    public boolean hasNext() {
        if (pos >= parrots.length ||
                parrots[pos] == null)
            return false;
        else
            return true;
    }
}
