package _Exams.Exam_22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackCaffeine = new ArrayDeque<>();
        ArrayDeque<Integer> queueDrinks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).forEach(n -> stackCaffeine.push(Integer.parseInt(n)));
        Arrays.stream(scanner.nextLine().split(", ")).forEach(n -> queueDrinks.offer(Integer.parseInt(n)));

        int totalCaffeine = 0;

        while (!stackCaffeine.isEmpty() && !queueDrinks.isEmpty()) {
            int caffeine = stackCaffeine.pop();
            int drink = queueDrinks.poll();
            int currentCaffeine = caffeine * drink;
            if (currentCaffeine + totalCaffeine <= 300) {
                totalCaffeine += currentCaffeine;
            } else {
                queueDrinks.offer(drink);
                if (totalCaffeine >= 30) {
                    totalCaffeine -= 30;
                }
            }
        }
        String result = !queueDrinks.isEmpty()
                ? String.join(", ", queueDrinks.stream().map(Object::toString).collect(Collectors.toList()))
                : "At least Stamat wasn't exceeding the maximum caffeine.";

        System.out.println(result);

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffeine);
    }
}
