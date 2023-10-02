package behavioral.observer;

public interface Usage {
    void register(Observer obj);
    void unregister(Observer obj);

    void notifyObservers();

    Object getUpdate(Observer obj);

}
