package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> predicate = word-> Character.isUpperCase(word.charAt(0));
        List<String> inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(predicate)
                .collect(Collectors.toList());

        System.out.println(inputArr.size());
        inputArr.forEach(System.out::println);
    }
}
