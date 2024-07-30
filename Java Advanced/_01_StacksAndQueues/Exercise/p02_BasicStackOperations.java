package _01_StacksAndQueues.Exercises.Stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commands = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int elementsToPush = commands[0];
        int elementsToPop = commands[1];
        int searchingElement = commands[2];

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        for (int i = 0; i < elementsToPush; i++) {
            numStack.push(input[i]);
        }
        for (int i = 0; i < elementsToPop; i++) {
            numStack.pop();
        }

        if (numStack.contains(searchingElement)) {
            System.out.println("true");
        } else if (numStack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(numStack));
        }
    }
}
