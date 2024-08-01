package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P11_ReverseMatrixDiagonals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();


        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        printDiagonals(matrix, rows, cols);
    }

    private static void printDiagonals(String[][] matrix, int rows, int cols) {
        int row = rows - 1;
        int col = cols - 1;

        while (row != -1){
            int r = row;
            int c = col;

            while (c < cols && r >= 0){
                System.out.print(matrix[r--][c++] + " ");
            }

            System.out.println();
            col--;

            if(col == -1){
                col = 0;
                row--;
            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }
}
