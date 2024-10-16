package ObjectOrientedPractice.Abstraction;

public class Main2 {

    public static void main(String[] args) {
        Parent p = new Child();
        p.disply();
        p.bark();
        Child c= (Child) p;
        c.bark2();
        Parent p2= new Child();
        p2.news();
        Polymorphism pol = new Polymorphism();
    }
    public static  void main(String args){

        System.out.println("new");
    }
    public void funct(){
        Parent p = new Parent();
    }

}
