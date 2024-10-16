package ObjectOrientedPractice.Abstraction;

public class Child extends  Parent{

    @Override
    public void  disply(){
        System.out.println("child display");
    }
    public  void bark(){
        System.out.println("child bark");
    }
    public  void bark2(){
        System.out.println("child bark2");
    }
    public static void  news(){
        System.out.println("child static");
    }
}
