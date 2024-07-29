package _01_StacksAndQueues.Lab.Stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P01_BrowserHistory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> urlStack = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (urlStack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    urlStack.pop();
                    System.out.println(urlStack.peek());
                }

            } else {
                urlStack.push(input);
                System.out.println(input);
            }
            input = scanner.nextLine();
        }
    }
}
