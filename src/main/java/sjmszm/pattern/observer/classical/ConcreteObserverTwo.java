package sjmszm.pattern.observer.classical;

public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo is notified.");
    }
}
