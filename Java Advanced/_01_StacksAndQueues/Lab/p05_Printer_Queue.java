package _01_StacksAndQueues.Lab.Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P05_Printer_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> printQueue = new ArrayDeque<>();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {

                if (printQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printQueue.poll());
                }
            } else {
                printQueue.offer(input);
            }

            input = scanner.nextLine();
        }
        for (String s : printQueue) {
            System.out.println(s);
        }
    }
}
