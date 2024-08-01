package _02_MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix);
        findSubMatrixAndSum(matrix);
    }

    private static void findSubMatrixAndSum(int[][] matrix) {
        int sum = Integer.MIN_VALUE;
        int bestStartingRow = 0;
        int bestStartingCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = 0;
                for (int startRow = row; startRow < row + 3; startRow++) {

                    for (int startCol = col; startCol < col + 3; startCol++) {
                        int currentNum = matrix[startRow][startCol];
                        currentSum += currentNum;
                    }
                }
                if (currentSum > sum) {
                    sum = currentSum;
                    bestStartingRow = row;
                    bestStartingCol = col;
                }
            }
        }

        print(matrix, sum, bestStartingRow, bestStartingCol);

    }

    private static void print(int[][] matrix, int sum, int bestStartingRow, int bestStartingCol) {
        System.out.println("Sum = " + sum);
        for (int row = bestStartingRow; row < bestStartingRow + 3; row++) {
            for (int col = bestStartingCol; col < bestStartingCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
