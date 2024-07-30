package _01_StacksAndQueues.Exercises.Stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> inputStack = new ArrayDeque<>();

        for (String s : input) {
            inputStack.push(s);
        }

        for (String s : inputStack) {
            System.out.printf("%s ", s);
        }
    }
}