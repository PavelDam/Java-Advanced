package _02_MultidimensionalArrays.Lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] firstMatrix = new int[rows][cols];
        fillMatrix(firstMatrix, scanner);

        rows = scanner.nextInt();
        cols = scanner.nextInt();
        scanner.nextLine();
        int[][] secondMatrix = new int[rows][cols];
        fillMatrix(secondMatrix, scanner);

        boolean areEqual = firstMatrix.length == secondMatrix.length && compareMatrix(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean compareMatrix(int[][] firstMatrix, int[][] secondMatrix) {

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
