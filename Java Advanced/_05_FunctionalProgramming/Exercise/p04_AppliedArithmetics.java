package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;

public class p04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        UnaryOperator<List<Integer>> add = num -> num.stream().map(e -> e + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = num -> num.stream().map(e -> e - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = num -> num.stream().map(e -> e * 2).collect(Collectors.toList());
        Consumer<List<Integer>> printer = num -> num.forEach(n -> System.out.print(n + " "));


        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    inputArr = add.apply(inputArr);
                    break;
                case "multiply":
                    inputArr = multiply.apply(inputArr);
                    break;
                case "subtract":
                    inputArr = subtract.apply(inputArr);
                    break;
                case "print":
                    printer.accept(inputArr);
                    System.out.println();
            }

            command = scanner.nextLine();
        }
    }
}
