package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endNum = Integer.parseInt(scanner.nextLine());
        List<Integer> dividersArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> predicate = n -> {
            for (Integer integer : dividersArr) {
                if (n % integer != 0) {
                    return false;
                }
            }
            return true;
        };
        IntStream.rangeClosed(1, endNum).boxed().filter(predicate).forEach(e -> System.out.print(e + " "));
    }
}
