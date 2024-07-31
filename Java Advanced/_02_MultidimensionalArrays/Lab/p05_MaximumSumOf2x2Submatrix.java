package _02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = Integer.MIN_VALUE;
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < matrix.length - 1; row++) {
            int currentSum = 0;
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int topLeft = matrix[row][col];
                int topRight = matrix[row][col + 1];
                int bottomLeft = matrix[row + 1][col];
                int bottomRight = matrix[row + 1][col + 1];
                currentSum = topLeft + topRight + bottomLeft + bottomRight;

                if (currentSum > maxSum) {
                    maxSum = currentSum;

                    builder = new StringBuilder();
                    builder.append(topLeft).append(" ").append(topRight).append(System.lineSeparator())
                            .append(bottomLeft).append(" ").append(bottomRight);
                }
            }
        }
        System.out.printf("%s%n%d", builder, maxSum);
    }
}
