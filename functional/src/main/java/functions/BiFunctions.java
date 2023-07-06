package functions;

import java.util.function.BiFunction;

//bifunction takes two param and return one item i.e BiFunction<T,U,R>
//t,u are input param and r is return type
public class BiFunctions {
    public static void main(String[] args) {

        BiFunction<Integer,Integer,Integer> addByTenAndMultiply=(number,numberToMultiply)->
                (number+1)*numberToMultiply;
        // here it takes two argument of type integer and produce result accordingly
        System.out.println(addByTenAndMultiply.apply(2, 10));
    }
}
