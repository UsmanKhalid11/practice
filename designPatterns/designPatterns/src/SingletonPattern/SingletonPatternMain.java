package SingletonPattern;

public class SingletonPatternMain {
    public static void main(String[] args) {
        //singleton pattern is example of creational design pattern
        //lazy loading
        SingletonPatternLazy singletonPatternLazy=SingletonPatternLazy.getSingletonPatternLazy();
        SingletonPatternLazy singletonPatternLazy1=SingletonPatternLazy.getSingletonPatternLazy();
        //eager loading
        SingletonPatternEager singletonPatternEager=SingletonPatternEager.getSingletonPatternEager();
        SingletonPatternEager singletonPatternEager1=SingletonPatternEager.getSingletonPatternEager();
        System.out.println(singletonPatternEager1);
        System.out.println(singletonPatternEager);
        //both objects have same reference
        //bill pugh method
        SingltonPatternBillPugh singltonPatternBillPugh=SingltonPatternBillPugh.getSingltonPatternBillPugh();

    }
}
