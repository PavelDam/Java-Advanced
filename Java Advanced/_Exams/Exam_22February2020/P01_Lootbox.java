package _Exams.Exam_22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).forEach(n -> queue.offer(Integer.parseInt(n)));
        Arrays.stream(scanner.nextLine().split(" ")).forEach(n -> stack.push(Integer.parseInt(n)));

        int sum = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int firstNum = queue.peek();
            int secondNum = stack.pop();

            if ((firstNum + secondNum) % 2 == 0) {
                sum += firstNum + secondNum;
                queue.poll();
            } else {
                queue.offer(secondNum);
            }
        }


        System.out.println(queue.isEmpty()
                ? "First lootbox is empty"
                : "Second lootbox is empty");

        System.out.print(sum >= 100
                ? String.format("Your loot was epic! Value: %d", sum)
                : String.format("Your loot was poor... Value: %d", sum));
    }
}
