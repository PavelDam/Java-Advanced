package _02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixSize[0];
        int cols = matrixSize[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);
        System.out.println(rows);
        System.out.println(cols);
        sumMatrix(matrix);

    }

    private static void sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNum = matrix[row][col];
                sum += currentNum;
            }
        }
        System.out.println(sum);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
