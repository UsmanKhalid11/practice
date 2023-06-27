import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

//https://www.youtube.com/watch?v=K1iu1kXkVoA
public class Generics {
    public static void main(String[] args) {
        //basically we have to write classes for different types in order to print a specific datatype variable
        //i.e for string we have to write class for string for int we have to write  for int in order to prevent that
        //we can write a single class using generics and use it for all here is an example
        Print<String>str=new Print<>("hello");
        Print<Integer>num=new Print<>(1);
        str.sysOut();
        num.sysOut();
        //as you can see a single class and single variable can be used for multiple types

        //example of bounded generic
       //PrintAnimals<Integer>prnAniml= new PrintAnimals<Integer>();  //will give compile error as it only permits generics extending Animals interface
        PrintAnimals<Dog>prnAniml= new PrintAnimals<Dog>(new Dog()); //will work as dog extends animal class
        //see internet for interface example

        //generic functions
        exclaim("hi");
        exclaim(2);
        exclaimTwice("hi",2);
        exclaimTwice(2,"hi");

        // wild cards represented by <?> symbol
        List<Integer> intLst= new ArrayList<>();
        intLst.add(22);
        prntLst(intLst);
        List<String> strLst= new ArrayList<>();
        strLst.add("hello");
        prntLst(strLst);

        //bounded wildcards

       // prntLstBound(strLst);//give compile error as String list does not extend Animal class;
        List<Animal> animals= new ArrayList<>();
        animals.add(new Dog());
        prntLstBound(animals);


    }
    //generic functions
    public static <T>void exclaim(T inp){
    System.out.println(inp+"!!!!!");
    }
    //generic functions
    public static <T,K>void exclaimTwice(T inp,K inp2){
        System.out.println(inp+"!!!!!");
        System.out.println(inp2+"!!!!!");
    }
    //generic functions return type example
    public static <T,K>T exclaimTwiceReturn(T inp,K inp2){
        System.out.println(inp+"!!!!!");
        System.out.println(inp2+"!!!!!");
        return inp;
    }
    //wild card example
    public static void prntLst(List<?> lst){
        lst.forEach((i)->{System.out.println(i);});
    }
    //bounded wild cards
    public static void prntLstBound(List<? extends Animal> lst){
        lst.forEach((i)->{System.out.println(i);});
    }
}










///////////study @refreshscope