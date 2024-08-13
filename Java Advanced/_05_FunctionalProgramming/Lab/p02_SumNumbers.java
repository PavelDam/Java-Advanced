package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class p02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Function<int[], String> sum = elements -> "Sum = " + Arrays.stream(elements).sum();

        System.out.println("Count = " + inputArr.length);
        System.out.println(sum.apply(inputArr));
    }
}
