package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        List<String> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> predicate = word -> word.length() <= length;

        inputList.stream().filter(predicate).forEach(System.out::println);
    }
}
