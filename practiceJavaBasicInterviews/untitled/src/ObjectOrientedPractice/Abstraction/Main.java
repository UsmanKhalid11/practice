package ObjectOrientedPractice.Abstraction;

public class Main {
    public static void main(String[] args) {
//upcasting will call method of child
        Parent p= new Child();

 //down casting explicitly is not possible but we can do it
        Child c1;
        Parent p2 = new Child();
        c1=(Child) p2;
        p.PrintData();
        c1.PrintData();

    }


    static class  Parent{
        void PrintData() {
            System.out.println("method of parent class");
        }
    }

    static class Child extends Parent {
        void PrintData() {
            System.out.println("method of child class");
        }
    }
}
