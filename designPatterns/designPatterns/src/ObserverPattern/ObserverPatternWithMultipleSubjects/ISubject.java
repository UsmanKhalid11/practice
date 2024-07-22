package ObserverPattern.ObserverPatternWithMultipleSubjects;

public interface ISubject {
    void register(IObserver o);
    void unregister(IObserver o);
}
