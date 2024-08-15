package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> function = list -> {
            int min = list.stream().mapToInt(e -> e).min().getAsInt();
            int index = list.lastIndexOf(min);
            return index;
        };
        System.out.println(function.apply(inputList));
    }

}
