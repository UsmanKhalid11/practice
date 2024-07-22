package ObserverPattern.ObserverPatternWithMultipleSubjects;

public class Observer3 implements IObserver {
    @Override
    public void updatedValueInsSubject(String s,int i) {

        System.out.println("From observer 3 Value updated is" +i+ " in subject "+s);
    }
}