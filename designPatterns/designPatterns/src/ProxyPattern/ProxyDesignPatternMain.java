package ProxyPattern;

public class ProxyDesignPatternMain {
    //Design pattern in which an orignal class is represented by proxy class
    //virtual proxy:-used for lazy initialization of object that is expensive to create
    //remote proxy:- to hide the location of orignal object
    //protection proxy :- to limit access to orignal object
    // smart proxy :- used to perform additional operations i.e logging, keeping count of refrences
    public static void main(String[] args) {
        ProxyClass pc = new ProxyClass();
        pc.doWork();
    }
}
