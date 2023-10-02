# Author: Siretanu Andreia-Cristina

----

# Topic: *Behavioral Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioral Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.__

&ensp; &ensp; __3. Create a new Project or add some additional functionalities using behavioral design patterns.__

## Theoretical background:
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

&ensp; &ensp; Some examples from this category of design patterns are :

* Chain of Responsibility
* Command
* Interpreter
* Iterator
* Mediator
* Observer
* Strategy

## Implementation

* Introduction

I decided to implement Strategy, Iterator, Observer and Command design patterns.
I created a java program that will show the payment process in an parrot market. 
The Iterator iterates the parrots that were added to buy. Observer notice the functions executed on the card accounts.

* Snippets from your files.

* Iterator:

```java
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

```

* Observer:

```java
public class CardUsage implements Usage {
    private List<Observer> observers;
    private String message;
    private boolean changed;

    public CardUsage() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        if (!observers.contains(obj)) observers.add(obj);

    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        if (!changed)
            return;
        observersLocal = new ArrayList<>(this.observers);
        this.changed = false;
        for (Observer obj : observersLocal) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("Message Posted to Topic:" + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }

}

```

* Command:

```java
public class FunctionalityInvoker {

    public Command command;

    public FunctionalityInvoker(Command c) {
        this.command = c;
    }

    public String execute() {
        return this.command.execute();
    }
}

```

* Strategy:

```java
public class ParrotTrack {
    List<Parrot> parrots;
    public ParrotTrack() {
        this.parrots = new ArrayList<>();
    }
    public void addParrot(Parrot parrot) {
        this.parrots.add(parrot);
    }
    public void removeParrot(Parrot parrot) {
        this.parrots.remove(parrot);
    }
    public int calculateTotal() {
        int sum = 0;
        for (Parrot parrot : parrots) {
            sum += parrot.getPrice();
        }
        return sum;
    }
    public void pay(PaymentStrategy paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}
```

Main Class:

```java
public class Main {
    public static void main(String[] args) {
        //Strategy
        ParrotTrack parrotTrack = new ParrotTrack();

        Parrot parrot1 = new Parrot("Codi", 100);
        Parrot parrot2 = new Parrot("Gosha", 40);

        parrotTrack.addParrot(parrot1);
        parrotTrack.addParrot(parrot2);

        parrotTrack.pay(new PaypalStrategy("email@example.com", "tsrg"));
        parrotTrack.pay(new CreditCardStrategy("Vasile", "5335643", "786", "12/15"));

        //Iterator
        ParrotCollection nc = new ParrotCollection();
        nc.addParrot("Gosha", 43);
        nc.addParrot("Codi", 53);
        ParrotCart nb = new ParrotCart(nc);
        nb.printItemsPrices();

        //Command
        //Creating the receiver object
        CreditCardStrategy creditCardStrategy = new CreditCardStrategy();
        PaypalStrategy paypalStrategy = new PaypalStrategy();
        CardFunctionality creditCard = CardTypeDeterminerUtil.getCardType(creditCardStrategy);
        CardFunctionality paypalCard = CardTypeDeterminerUtil.getCardType(paypalStrategy);

        Command transfer = new Transfer(creditCard);
        FunctionalityInvoker invoker = new FunctionalityInvoker(transfer);
        String transferInvoker = invoker.execute();
        Command deposite = new Deposite(creditCard);
        invoker = new FunctionalityInvoker(deposite);
        String depositInvoker = invoker.execute();

        Command payment = new Payment(paypalCard);
        invoker = new FunctionalityInvoker(payment);
        String paymentInvoker = invoker.execute();

        //Observer
        CardUsage creditCardUsage = new CardUsage();
        CardUsage paypalUsage = new CardUsage();
        Observer creditCardObserver = new CardUsageSubscriber("Credit Card observer ");
        Observer paypalObserver = new CardUsageSubscriber("Paypal Observer ");
        creditCardUsage.register(creditCardObserver);
        paypalUsage.register(paypalObserver);

        creditCardObserver.setSubject(creditCardUsage);
        paypalObserver.setSubject(paypalUsage);

        creditCardObserver.update();
        paypalObserver.update();

        creditCardUsage.postMessage(transferInvoker);
        paypalUsage.postMessage(paymentInvoker);
    }
}
```

## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I have chosen.
In my code I managed to implement somehow 4 behavioral design patterns. Moreover, I managed not only to copy and use them,
but also to interconnect them.