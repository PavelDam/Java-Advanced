package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            boolean isValid = commandValidation(command, rows, cols);
            if (isValid) {
                swapElements(matrix, command);
                printCurrentStatement(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static void printCurrentStatement(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static void swapElements(String[][] matrix, String[] command) {
        int firstRow = Integer.parseInt(command[1]);
        int firstCol = Integer.parseInt(command[2]);
        int secondRow = Integer.parseInt(command[3]);
        int secondCol = Integer.parseInt(command[4]);

        String firstElement = matrix[firstRow][firstCol];
        String secondElement = matrix[secondRow][secondCol];

        matrix[secondRow][secondCol] = firstElement;
        matrix[firstRow][firstCol] = secondElement;
    }

    private static boolean commandValidation(String[] command, int rows, int cols) {

        if (command.length != 5) {
            return false;
        }
        int firstRow = Integer.parseInt(command[1]);
        int firstCol = Integer.parseInt(command[2]);
        int secondRow = Integer.parseInt(command[3]);
        int secondCol = Integer.parseInt(command[4]);

        return firstRow >= 0 && firstRow <= rows && secondRow >= 0 && secondRow <= rows && firstCol >= 0 && firstCol <= cols && secondCol >= 0 && secondCol <= cols;

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
