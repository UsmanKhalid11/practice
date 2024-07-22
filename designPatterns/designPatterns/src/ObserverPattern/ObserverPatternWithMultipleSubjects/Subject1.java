package ObserverPattern.ObserverPatternWithMultipleSubjects;

import java.util.ArrayList;
import java.util.List;

public class Subject1 implements ISubject {

    int flag=0;
    List<IObserver> observers= new ArrayList<>();

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
        notifyObservers(flag);
    }
    private void notifyObservers(int updateValue){
        observers.forEach(
                item->item.updatedValueInsSubject(this.getClass().getSimpleName(),updateValue));
    }

    @Override
    public void register(IObserver o) {
        this.observers.add(o);
    }

    @Override
    public void unregister(IObserver o) {
        this.observers.remove(o);
    }
}
