# Author: Siretanu Andreia-Cristina

----

# Topic: *Structural Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using structural design patterns.__

## Theoretical background:
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

&ensp; &ensp; Some examples of from this category of design patterns are:

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Proxy

## Implementation

* Introduction

I decided to implement Adapter, Bridge, Composite and Decorator design patterns.
I created a java program where there is are Bears and Chickens and they have food represented in different types, then we adapt bear to chicken.

* Snippets from your files.

* Adapter:

```java
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
```

* Bridge:

```java
public abstract class ChickenFeedType {
    protected ChickenFeed chickenFeed;

    public ChickenFeedType(ChickenFeed chickenFeed){
        this.chickenFeed = chickenFeed;
    }

    abstract public int additionPrice();
}
```

* Composite:

```java
public class MeatFood {
    private int price;

    public MeatFood(int price) {
        this.price = price;
    }

    private List<Meat> meats = new ArrayList<>();

    public void showMeat(int quantity) {
        for(Meat sh : meats) {
            sh.eat(quantity);
        }
    }

    public void add(Meat s){
        this.meats.add(s);
    }

    public int getPrice() {
        return price * meats.size();
    }

    public void clear(){
        System.out.println("Clear meat");
        this.meats.clear();
    }
}
```

* Decorator:

```java
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
```

Main class:

```java
 public class Main {
    public static void main(String[] args) {
        //Bridge
        ChickenFeedType chickenFeedType = new Wheat(new DirtFeed(), 100);
        chickenFeedType.additionPrice();

        ChickenFeedType chickenFeedType1 = new Corn(new ClearFeed(), 200);
        chickenFeedType1.additionPrice();

        //Composite
        Meat fish = new Fish();
        Meat fish1 = new Fish();
        Meat cowMeat = new CowMeat();
        MeatFood meatFood = new MeatFood(100);
        meatFood.add(fish1);
        meatFood.add(fish1);
        meatFood.add(cowMeat);
        meatFood.showMeat(50);
        meatFood.clear();
        meatFood.add(fish);
        meatFood.add(cowMeat);
        meatFood.showMeat(20);

//        Decorator
        Bear whiteBear = new WhiteBear(new BrownBear("Po", 5, meatFood), 10);
        System.out.println(whiteBear.finalPrice());

        Bear whiteBear1 = new WhiteBear(new BlackBear(new BrownBear("Dave", 3, meatFood), 30), 20);
        System.out.println(whiteBear1.finalPrice());

//        Adapter
        ChickenAbilities chickenAbilities = new Chicken(chickenFeedType1, 100);
        ChickenAbilities bearAdapter = new BearAdapter(whiteBear);
        System.out.println(chickenAbilities.displayFinalPrice());
        bearAdapter.fly();
    }
}
```
## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I have chosen.
In my code I managed to implement somehow 4 structural design patterns. Moreover, I managed not only to copy and use them,
but also to interconnect them.