package functions;

import java.util.function.Function;

// example of functions keyword java
//syntax Function<T,R> t is param type and r is return type
public class Functions {
    public static void main(String[] args) {
        Function<Integer,Integer> addByOne=number->number+1;
        System.out.println(addByOne.apply(1));// we use apply function to implement owr code
        //Chaining function example
        Function<Integer,Integer> multiplyByTen=number->number*10;
        System.out.println(multiplyByTen.apply(1));
        Function<Integer,Integer> chainingFuntion=addByOne.andThen(multiplyByTen);
        // chaining function example both functions are chained into one function and
        // then applied together

        System.out.println(chainingFuntion.apply(1));
    }
}
