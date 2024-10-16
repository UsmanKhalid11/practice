package ObjectOrientedPractice.Abstraction;
public class Main3 {
    public static void main(String[] args) {
        // Parent reference to Parent object
        Parent parentObj = new Parent();
        parentObj.display();  // Output: Static method in Parent class
        parentObj.show();     // Output: Non-static method in Parent class

        // Child reference to Child object
        Child childObj = new Child();
        childObj.display();   // Output: Static method in Child class
        childObj.show();      // Output: Non-static
// Parent reference to Child object (Upcasting)
        Parent parentRef = new Child();
        parentRef.display();  // Output: Static method in Parent class (Method hiding)
        parentRef.show();     // Output: Non-static method in Child class (Method overriding)
    }



    static  class Parent {
        // Static method in Parent class
        public static void display() {
            System.out.println("Static method in Parent class");
        }

        // Non-static method in Parent class
        public void show() {
            System.out.println("Non-static method in Parent class");
        }
    }
    static class Child extends Parent {
        // Hiding the static method from Parent class
        public static void display() {
            System.out.println("Static method in Child class");
        }

        // Overriding the non-static method from Parent class
        @Override
        public void show() {
            System.out.println("Non-static method in Child class");
        }
    }
}