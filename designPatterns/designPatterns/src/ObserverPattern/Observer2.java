package ObserverPattern;

public class Observer2 implements IObserver{
    @Override
    public void updatedValueInsSubject(int i) {
        System.out.println("From observer 2 Value updated is" +i);
    }
}
