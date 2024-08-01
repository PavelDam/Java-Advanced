package _02_MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        fillMatrix(matrix, scanner);
        findAndPrintDiagonalsSum(matrix, size);
    }

    private static void findAndPrintDiagonalsSum(int[][] matrix, int size) {
        int primaryDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonal += matrix[i][i];
        }
        int secondaryDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            secondaryDiagonal += matrix[i][size - 1 - i];
        }
        int sum = Math.abs(primaryDiagonal - secondaryDiagonal);
        System.out.println(sum);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
