package _Exams.RetakeExam_18August2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> licensePlatesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(licensePlatesQueue::offer);
        ArrayDeque<Integer> carsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(carsStack::push);

        int countOfRegisteredCars = 0;
        int days = 0;
        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {
            days++;
            int licensePlates = licensePlatesQueue.poll();
            int cars = carsStack.pop();

            if (licensePlates > (cars * 2)) {
                licensePlatesQueue.addLast(licensePlates - (cars * 2));
                countOfRegisteredCars += cars;
            } else if (licensePlates < (cars * 2)) {
                int leftCars = cars - (licensePlates / 2);
                carsStack.addLast(leftCars);
                countOfRegisteredCars += (licensePlates / 2);
            } else {
                countOfRegisteredCars += cars;
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", countOfRegisteredCars, days);
        if (!licensePlatesQueue.isEmpty()) {
            int sum = licensePlatesQueue.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("%d license plates remain!%n", sum);
        }
        if (!carsStack.isEmpty()) {
            int sum = carsStack.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("%d cars remain without license plates!", sum);
        }
        if (carsStack.isEmpty() && licensePlatesQueue.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
