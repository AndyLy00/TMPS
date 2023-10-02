package behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

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
