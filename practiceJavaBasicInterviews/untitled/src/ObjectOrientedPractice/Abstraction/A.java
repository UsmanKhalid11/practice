package ObjectOrientedPractice.Abstraction;

public interface A {
    String a ="sup";
    default void newq(){
        System.out.println(" from int a");
    }
}
