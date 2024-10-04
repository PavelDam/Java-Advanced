package _01_WorkingWithAbstraction.Exercise.P01_CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(input + ":");

        CardSuite.printAll();
    }
}
