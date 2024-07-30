package _01_StacksAndQueues.Exercises.Stacks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            String[] commandArr = scanner.nextLine().split(" ");
            switch (commandArr[0]){
                case "1":
                    stack.push(Integer.parseInt(commandArr[1]));
                    break;
                case"2":
                    stack.pop();
                    break;
                case"3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
