package _01_StacksAndQueues.Exercises.Queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commandsArr = scanner.nextLine().split(" ");

        int elementsToOffer = Integer.parseInt(commandsArr[0]);
        int elementsToPoll = Integer.parseInt(commandsArr[1]);
        int elementsToCheck = Integer.parseInt(commandsArr[2]);

        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < elementsToOffer; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < elementsToPoll; i++) {
            queue.poll();
        }
        if (queue.contains(elementsToCheck)){
            System.out.println("true");
        }else if (queue.isEmpty()){
            System.out.println(0);
        }else {
            System.out.println(Collections.min(queue));
        }
    }
}
