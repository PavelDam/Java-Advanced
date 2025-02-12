package _08_ExceptionAndErrorHandling.P02_SquareRoot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        try {
            double sqrt = sqrt(number);
            System.out.printf("%.2f%n", sqrt);
        } catch (IllegalArgumentException ignored) {
            System.out.println("Invalid");
        }finally {
            System.out.println("Goodbye");
        }
    }

    private static double sqrt(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new IllegalArgumentException("Number: " + number + "is less than 0");
        }
        return Math.sqrt(number);
    }
}
