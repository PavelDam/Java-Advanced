package _05_FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputList = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> function = element -> Collections.min(Arrays.stream(element).boxed().collect(Collectors.toList()));
        int min = function.apply(inputList);
        System.out.println(min);

    }
}

