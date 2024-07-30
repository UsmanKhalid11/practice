package ProxyPattern;
//Orignal class that will be called through proxy
public class ConcreteClass  implements   Subject{
    @Override
    public void doWork() {
        System.out.println("Working from concrete class");
    }
}
