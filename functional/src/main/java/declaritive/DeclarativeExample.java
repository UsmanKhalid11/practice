package declaritive;
/*Declarative Programming Example: interested in what we want
        In this example, we use the Arrays.
        stream method in Java to convert the array of numbers into a stream.
        Then, we use the sum method provided by the stream API to calculate
        the sum of all the elements in a declarative manner. The code does
        not explicitly state how to perform the sum operation.
        it only declares the desired outcome. The underlying system takes
        care of the implementation details.

        In the declarative approach, you rely on higher-level abstractions
        and let the language or libraries handle the implementation details.
        This allows for more concise and expressive code.*/

import java.util.Arrays;

public class DeclarativeExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(numbers).sum();

        System.out.println("The sum is: " + sum);
    }
}