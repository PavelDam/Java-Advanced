package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class p01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<String> printer = System.out::println;

        inputArr.forEach(printer);
    }
}
