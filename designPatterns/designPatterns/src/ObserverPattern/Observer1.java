package ObserverPattern;

public class Observer1 implements IObserver {


    @Override
    public void updatedValueInsSubject(int i) {
        System.out.println("From observer 1 Value updated is" +i);
    }
}
