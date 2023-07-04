package imperative;
/*Imperative Programming Example: interested in how we want

        In this example, we have an array of numbers,
        and we use a for loop to iterate over each element
        and calculate their sum. The code explicitly defines
        the steps to be taken and the order of execution.
        It follows an imperative approach by instructing the
        computer on how to perform the task.*/

public class ImperativeExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("The sum is: " + sum);
    }
}