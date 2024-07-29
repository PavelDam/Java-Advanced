package _01_StacksAndQueues.Lab.Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> urlStack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (urlStack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardStack.push(urlStack.pop());
                    System.out.println(urlStack.peek());
                }

            } else if (input.equals("forward")) {
                if (forwardStack.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardStack.peek());
                    urlStack.push(forwardStack.pop());

                }
            } else {
                urlStack.push(input);
                System.out.println(input);
                forwardStack.clear();
            }
            input = scanner.nextLine();
        }
    }
}
