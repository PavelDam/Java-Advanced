package _01_StacksAndQueues.Lab.Queues;

import java.util.*;

public class P06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");

        int steps = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();
        for (int i = 0; i < names.length; i++) {
            kids.offer(names[i]);
        }
        while (kids.size() > 1) {
            for (int i = 1; i < steps; i++) {
                String kid = kids.poll();
                kids.offer(kid);
            }
            System.out.println("Removed " + kids.poll());
        }
        System.out.println("Last is " + kids.poll());
    }
}
