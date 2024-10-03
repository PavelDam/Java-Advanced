package _01_WorkingWithAbstraction.Lab.P03_StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StudentSystem studentSystem = new StudentSystem();
        while (!input.equals("Exit")) {

            studentSystem.parseCommand(input);

            input = scanner.nextLine();
        }

    }
}
