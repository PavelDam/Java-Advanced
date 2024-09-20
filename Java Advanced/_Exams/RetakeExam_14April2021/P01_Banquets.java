package _Exams.RetakeExam_14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_Banquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(daffodilsQueue::offer);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tulipsStack::push);

        int bouquets = 0;
        int flowers = 0;
        while (!daffodilsQueue.isEmpty() && !tulipsStack.isEmpty()) {
            int daffodil = daffodilsQueue.peek();
            int tulip = tulipsStack.pop();
            int sum = daffodil + tulip;

            if (sum > 15) {
                tulip -= 2;
                tulipsStack.push(tulip);
            } else if (sum < 15) {
                daffodilsQueue.poll();
                flowers += sum;
            } else {
                bouquets++;
                daffodilsQueue.poll();
            }
        }
        while (flowers >= 15) {
            bouquets++;
            flowers -= 15;
        }
        System.out.print(bouquets >= 5
                ? String.format("You made it! You go to the competition with %d bouquets!", bouquets)
                : String.format("You failed... You need more %d bouquets.", 5 - bouquets));
    }
}
