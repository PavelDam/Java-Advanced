package _02_MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = rows;

        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);

        int valueRow = scanner.nextInt();
        int valueCol = scanner.nextInt();
        int wrongValue = matrix[valueRow][valueCol];
        List<int[]> correctValues = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];
                if (currentNumber == wrongValue) {
                    // correctValues.add(new int[]{row, col, correctValue});
                    currentNumber = getNearbySum(matrix, row, col, wrongValue);

                }
                System.out.print(currentNumber + " ");
            }
            System.out.println();
        }
//        for (int[] correctValue : correctValues) {
//            int row = correctValue[0];
//            int col = correctValue[1];
//            matrix[row][col] = correctValue[2];
//        }
//        for (int[] arr : matrix) {
//            for (int n : arr) {
//                System.out.print(n+" ");
//            }
//            System.out.println();
//        }
    }

    private static int getNearbySum(int[][] matrix, int row, int col, int wrongNumber) {
        int sum = 0;
        if (isInBounds(matrix, row + 1, col, wrongNumber)) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(matrix, row - 1, col, wrongNumber)) {
            sum += matrix[row - 1][col];
        }
        if (isInBounds(matrix, row, col + 1, wrongNumber)) {
            sum += matrix[row][col + 1];
        }
        if (isInBounds(matrix, row, col - 1, wrongNumber)) {
            sum += matrix[row][col - 1];
        }
        return sum;
    }

    //!!!!!!!!!! проверка дали индекса е в ганиците на масива
    private static boolean isInBounds(int[][] matrix, int row, int col, int wrongNumber) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length && matrix[row][col] != wrongNumber;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
