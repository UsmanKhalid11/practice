public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        OuterClass.Nested nested= new OuterClass.Nested();
        nested.printHello();
    }
}