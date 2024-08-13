package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class p06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int start = inputArr[0];
        int end = inputArr[1];
        String filter = scanner.nextLine();
        IntPredicate predicate = getPredicate(filter);
        IntStream.rangeClosed(start, end).filter(predicate).forEach(num -> System.out.print(num + " "));
    }

    private static IntPredicate getPredicate(String filter) {
        switch (filter) {
            case "odd":
                return i -> i % 2 != 0;
            case "even":
                return i -> i % 2 == 0;
            default:
                throw new IllegalArgumentException("Unknown filter: " + filter);
        }
    }
}
