package _01_StacksAndQueues.Exercises.Queues;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.length() % 2 != 0) {
            System.out.println("NO");
            return;
        }

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if (currentBracket == '[' || currentBracket == '(' || currentBracket == '{') {
                openBracketsStack.push(currentBracket);
            } else {
                char open = openBracketsStack.pop();
                char close = input.charAt(i);
                if (open == '(' && close != ')' || open == '[' && close != ']' || open == '{' && close != '}') {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}