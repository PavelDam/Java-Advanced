package _01_StacksAndQueues.Lab.Stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>(Arrays.asList(input));

        int result = 0;
        while (stack.size() > 1) {
            int a = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int b = Integer.parseInt(stack.pop());

            switch (operator) {

                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
            }
            stack.push(String.valueOf(result));

        }
        System.out.println(stack.peek());

    }
}
