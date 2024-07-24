package SingletonPattern;
//Lazy loading is bit thread unsafe we can make it thread safe by adding synchronized block but
// it will hinder the performance
//for this we can use eager loading. but this will have a draw back as well because an object will
// always be there whether we use it or not
//
public class SingletonPatternEager {
    private static SingletonPatternEager singletonPatternEager=new SingletonPatternEager();
    private SingletonPatternEager(){}
    public static  SingletonPatternEager getSingletonPatternEager(){
        return singletonPatternEager;
    }
}
