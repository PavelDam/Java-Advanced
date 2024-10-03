package _01_WorkingWithAbstraction.Lab;

import java.util.Scanner;

public class P01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rhombusSize = Integer.parseInt(scanner.nextLine());

        printRhombusUpperPart(rhombusSize);

        printRhombusMiddleRow(rhombusSize);

        printRhombusLowerPart(rhombusSize);
    }

    private static void printRhombusLowerPart(int rhombusSize) {
        for (int row = rhombusSize - 1; row >= 1; row--) {
            for (int space = 0; space < rhombusSize - row; space++) {
                System.out.print(" ");
            }
            for (int star = 0; star < row; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printRhombusMiddleRow(int rhombusSize) {
        for (int star = 0; star < rhombusSize; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printRhombusUpperPart(int rhombusSize) {
        for (int row = 1; row <= rhombusSize - 1; row++) {
            for (int space = row; space <= rhombusSize - 1; space++) {
                System.out.print(" ");
            }
            for (int star = 0; star < row; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
