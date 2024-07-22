package ObserverPattern.ObserverPatternWithMultipleSubjects;

public class Observer1 implements IObserver {


    @Override
    public void updatedValueInsSubject(String s,int i) {

        System.out.println("From observer 1 Value updated is" +i+ " in subject "+s);
    }
}
