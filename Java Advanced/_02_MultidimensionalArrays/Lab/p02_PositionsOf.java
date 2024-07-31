package _02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);

        int searchingNumber = scanner.nextInt();

        search(matrix, searchingNumber);
    }

    private static void search(int[][] matrix, int searchingNumber) {
        //StringBuilder builder = new StringBuilder();
        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];
                if (currentNumber == searchingNumber) {
                    System.out.println(row + " " + col);
                    isFound = true;
//                    builder.append(row).append(" ").append(col).append(System.lineSeparator());
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
        //System.out.println(builder.isEmpty() ? "not found" :builder.toString());
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
