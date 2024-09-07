package _Exams.Exam_20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(n -> firstBox.offer(Integer.parseInt(n)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(n -> secondBox.push(Integer.parseInt(n)));
        int sum = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstNum = firstBox.peek();
            int secondNum = secondBox.pop();
            int currentSum = firstNum + secondNum;

            if (currentSum % 2 == 0) {
                sum += currentSum;
                firstBox.poll();
            } else {
                firstBox.offer(secondNum);
            }

        }
        System.out.println(firstBox.isEmpty() ? "First magic box is empty."
                : "Second magic box is empty.");


        System.out.printf((sum >= 90) ? "Wow, your prey was epic! Value: %d"
                : "Poor prey... Value: %d", sum);

    }
}
