public class OuterClass {
  Integer number;
  String name;
  public static  class Nested{
      Nested nested;
      String value;
      public void printHello(){
          System.out.println("hello from nested static class");
      }
  }
}