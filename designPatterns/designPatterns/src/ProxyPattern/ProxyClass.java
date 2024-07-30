package ProxyPattern;
//using proxy class as virtual proxy to lazy initialize expensive object creation.
public class ProxyClass implements Subject{

    ConcreteClass cs;
    @Override
    public void doWork() {
        if(cs==null)
            cs= new ConcreteClass();
        cs.doWork();
    }
}
