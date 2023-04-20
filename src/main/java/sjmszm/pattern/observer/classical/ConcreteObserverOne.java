package sjmszm.pattern.observer.classical;

public class ConcreteObserverOne implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverOne is notified.");

    }
}
