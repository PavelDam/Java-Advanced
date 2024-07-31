package _02_MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 8;
        int cols = 8;

        char[][] matrix = new char[rows][cols];
        fillMatrix(matrix, scanner);
        findQueen(matrix);
    }

    private static void findQueen(char[][] matrix) {
        int queenRow = 0;
        int queenCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currentSymbol = matrix[row][col];
                boolean notFindOthers = false;
                if (currentSymbol == 'q') {
                    queenRow = row;
                    queenCol = col;
                    notFindOthers = searchingForOtherQueens(matrix, queenRow, queenCol);
                }
                if (notFindOthers) {
                    System.out.println(queenRow + " " + queenCol);
                    return;
                }
            }
        }
    }

    private static boolean searchingForOtherQueens(char[][] matrix, int queenRow, int queenCol) {
        int col = 0;
        int row = 0;
        //horizontal search
        while (col < matrix.length) {
            if (col == queenCol) {
                col++;
                continue;
            }

            if (finding(matrix[queenRow], col)) return false;
            col++;
        }
        //vertical search
        while (row < matrix.length) {
            if (row == queenRow) {
                row++;
                continue;
            }
            if (finding(matrix[row], queenCol)) return false;
            row++;
        }
        //left diagonal
        row = queenRow + 1;
        col = queenCol + 1;
        while (row < matrix.length && col < matrix[row].length) {
            if (finding(matrix[row], col)) return false;
            row++;
            col++;
        }
        row = queenRow - 1;
        col = queenCol - 1;
        while (row >= 0 && col >= 0) {
            if (finding(matrix[row], col)) return false;
            row--;
            col--;
        }
        //right diagonal
        row = queenRow - 1;
        col = queenCol + 1;
        while (row >= 0 && col < matrix[row].length) {
            if (finding(matrix[row], col)) return false;

            row--;
            col++;
        }
        row = queenRow + 1;
        col = queenCol - 1;
        while (row < matrix.length && col >= 0) {
            if (finding(matrix[row], col)) return false;
            row++;
            col--;
        }
        return true;
    }

    private static boolean finding(char[] matrix, int col) {
        char currentSymbol = matrix[col];
        if (currentSymbol == 'q') {
            return true;
        }
        return false;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

        }
    }
}
