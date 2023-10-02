package behavioral;

import behavioral.command.CardTypeDeterminerUtil;
import behavioral.command.cards.CardFunctionality;
import behavioral.command.cards.CreditCardStrategy;
import behavioral.command.cards.PaypalStrategy;
import behavioral.command.functionality.*;
import behavioral.iterator.ParrotCart;
import behavioral.iterator.ParrotCollection;
import behavioral.observer.CardUsage;
import behavioral.observer.CardUsageSubscriber;
import behavioral.observer.Observer;
import behavioral.strategy.Parrot;
import behavioral.strategy.ParrotTrack;

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

