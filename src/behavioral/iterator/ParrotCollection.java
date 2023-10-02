package behavioral.iterator;


import behavioral.strategy.Parrot;

public class ParrotCollection implements Collection
{
    static final int MAX_ITEMS = 10;
    int numberOfItems = 0;
    Parrot[] parrots;

    public ParrotCollection()
    {
        parrots = new Parrot[MAX_ITEMS];
    }

    public void addParrot(String str, int price)
    {
        Parrot parrot = new Parrot(str, price);
        if (numberOfItems >= MAX_ITEMS)
            System.err.println("Full");
        else
        {
            parrots[numberOfItems] = parrot;
            numberOfItems = numberOfItems + 1;
        }
    }

    public Iterator createIterator()
    {
        return new ParrotIterator(parrots);
    }
}