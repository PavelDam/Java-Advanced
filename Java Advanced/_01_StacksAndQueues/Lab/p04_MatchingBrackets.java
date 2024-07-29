package _01_StacksAndQueues.Lab.Stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> indexStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '(') {
                indexStack.push(i);
            }
            if (symbol == ')') {
                System.out.println(input.substring(indexStack.pop(), i + 1));
            }
        }
    }
}
