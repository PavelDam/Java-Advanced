package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix) {
        char leftLetter = 'a';
        char middleLetter = 'a';
        char rightLetter = 'a';

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf(leftLetter) + middleLetter + rightLetter;
                middleLetter++;
            }
            leftLetter++;
            middleLetter = leftLetter;
            rightLetter++;
        }
    }
}
