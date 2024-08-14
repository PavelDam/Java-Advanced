package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class p02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<String> printer = word -> System.out.println("Sir " + word);

        inputArr.forEach(printer);
    }
}
