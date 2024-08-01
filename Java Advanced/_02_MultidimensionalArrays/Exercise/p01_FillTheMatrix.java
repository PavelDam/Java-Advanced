package _02_MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int startNumber = 1;

        int[][] matrix = new int[size][size];

        fillMatrix(matrix, size, startNumber, pattern);

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, int size, int startNumber, String pattern) {
        switch (pattern) {

            case "A":
                for (int col = 0; col < matrix.length; col++) {
                    for (int row = 0; row < matrix[col].length; row++) {
                        matrix[row][col] = startNumber;
                        startNumber++;
                    }
                }

                break;
            case "B":
                int colCount = 0;
                for (int col = 0; col < matrix.length; col++) {
                    if (colCount % 2 == 0) {
                        for (int row = 0; row < matrix[col].length; row++) {
                            matrix[row][col] = startNumber;
                            startNumber++;
                        }
                    } else {
                        for (int row = matrix.length - 1; row >= 0; row--) {
                            matrix[row][col] = startNumber;
                            startNumber++;
                        }
                    }
                    colCount++;
                }
                break;
        }
    }
}
