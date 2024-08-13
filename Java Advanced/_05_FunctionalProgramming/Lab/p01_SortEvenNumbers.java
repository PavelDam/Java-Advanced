package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).filter(n -> n % 2 == 0).toArray();

        System.out.println(Arrays.stream(inputArr).boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(Arrays.stream(inputArr).sorted().boxed()
                .map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
