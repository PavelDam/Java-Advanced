package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int divider = Integer.parseInt(scanner.nextLine());
        Collections.reverse(inputList);

        Predicate<Integer> predicate = n -> n % divider == 0;
        inputList.removeIf(predicate);
        inputList.forEach(e -> System.out.print(e + " "));
    }
}
