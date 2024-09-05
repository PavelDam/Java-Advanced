package _Exams.Exam_19February2022;

import java.util.Scanner;

public class P02_PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        int wRow = 0;
        int wCol = 0;
        int bRow = 0;
        int bCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                if (line.charAt(col) == 'w') {
                    wRow = row;
                    wCol = col;
                }
                if (line.charAt(col) == 'b') {
                    bRow = row;
                    bCol = col;
                }
                matrix[row][col] = line.charAt(col);
            }
        }
        playGame(matrix, wRow, wCol, bRow, bCol);
    }

    private static void playGame(char[][] matrix, int wRow, int wCol, int bRow, int bCol) {
        String color;

        while (wRow > 0 && bRow < 7) {

            color = "White";

            if (wCol > 0 && matrix[wRow - 1][wCol - 1] == 'b' || wCol < 7 && matrix[wRow - 1][wCol + 1] == 'b') {
                matrix[wRow][wCol] = '-';
                matrix[bRow][bCol] = 'w';

                capturePrint(color, findCoordinates(bRow,bCol));
                return;
            }

            matrix[wRow][wCol] = '-';
            matrix[--wRow][wCol] = 'w';

            if (wRow == 0) {
                promotedPrint(color, findCoordinates(wRow,wCol));
                return;
            }

            color = "Black";

            if (bCol > 0 && matrix[bRow + 1][bCol - 1] == 'w' || bCol < 7 && matrix[bRow + 1][bCol + 1] == 'w') {
                matrix[wRow][wCol] = 'b';
                matrix[bRow][bCol] = '-';

                capturePrint(color, findCoordinates(wRow,wCol));
                return;
            }

            matrix[bRow][bCol] = '-';
            matrix[++bRow][bCol] = 'b';

            if (bRow == 7) {
                promotedPrint(color, findCoordinates(bRow,bCol));
                return;
            }
        }
    }

    private static void capturePrint(String color, String coordinates) {
        System.out.printf("Game over! %s capture on %s.", color, coordinates);
    }

    private static void promotedPrint(String color, String coordinates) {
        System.out.printf("Game over! %s pawn is promoted to a queen at %s.", color,coordinates);
    }

    private static String findCoordinates(int bRow, int bCol) {
        char[] col = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        return String.valueOf(col[bCol]) + row[bRow];
    }
}



