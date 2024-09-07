package _Exams.Exam_20February2021;

import java.util.Arrays;
import java.util.Scanner;

public class P02_Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[] movesArr = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];


        int[] coordinates = fillMatrix(matrix, scanner);
        int startRow = coordinates[0];
        int startCol = coordinates[1];
        int bombs = coordinates[2];


        moving(movesArr, matrix, startRow, startCol, bombs);

    }

    private static void moving(String[] movesArr, char[][] matrix, int startRow, int startCol, int bombs) {
        int row = startRow;
        int col = startCol;
        for (int move = 0; move < movesArr.length; move++) {
            String currentMove = movesArr[move];
            int newRow = row;
            int newCol = col;
            switch (currentMove) {
                case "up":
                    newRow--;
                    break;
                case "down":
                    newRow++;
                    break;
                case "left":
                    newCol--;
                    break;
                case "right":
                    newCol++;
                    break;
            }
            if (isInBounds(matrix, newRow, newCol)) {
                row = newRow;
                col = newCol;

                char symbol = matrix[row][col];
                if (symbol == 'B') {
                    System.out.println("You found a bomb!");
                    bombs--;
                }
                if (symbol == 'e') {
                    System.out.printf("END! %d bombs left on the field", bombs);
                    return;
                }
                if (bombs == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs, row, col);
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[] fillMatrix(char[][] matrix, Scanner scanner) {
        int[] coordinates = new int[3];
        for (int row = 0; row < matrix.length; row++) {
            char[] line = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = line[col];
                if (symbol == 's') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
                if (symbol == 'B') {
                    coordinates[2]++;
                }
                matrix[row][col] = line[col];
            }
        }
        return coordinates;
    }
}
