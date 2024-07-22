package ObserverPattern.ObserverPatternWithMultipleSubjects;

public class Observer2 implements IObserver {
    @Override
    public void updatedValueInsSubject(String s,int i) {

        System.out.println("From observer 2 Value updated is" +i+ " in subject "+s);
    }
}
