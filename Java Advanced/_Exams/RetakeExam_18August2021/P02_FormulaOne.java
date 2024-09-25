package _Exams.RetakeExam_18August2021;

import java.util.Scanner;

public class P02_FormulaOne {
    private static final char PLAYER = 'P';
    private static final char EMPTY = '.';
    private static final char BONUS = 'B';
    private static final char FINISH = 'F';
    private static final char TRAP = 'T';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int[] coordinates = fillMatrixAndGetCoordinates(matrix, scanner);
        int row = coordinates[0];
        int col = coordinates[1];

        boolean finished = false;
        int i = 1;

        while (i <= commandsCount && !finished) {
            String command = scanner.nextLine();
            matrix[row][col] = EMPTY;

            int previousRow = row;
            int previousCol = col;

            int stepRow = 0;
            int stepCol = 0;
            switch (command) {
                case "up":
                    stepRow--;
                    break;
                case "down":
                    stepRow++;
                    break;
                case "left":
                    stepCol--;
                    break;
                case "right":
                    stepCol++;
                    break;

            }
            row = getPosition(matrix, row, stepRow);
            col = getPosition(matrix, col, stepCol);
            char symbol = matrix[row][col];
            if (symbol == BONUS) {
                row = getPosition(matrix, row, stepRow);
                col = getPosition(matrix, col, stepCol);

            } else if (symbol == TRAP) {
                row = previousRow;
                col = previousCol;
            } else if (symbol == FINISH) {
                finished = true;
            }
            matrix[row][col] = PLAYER;
            i++;
        }
        System.out.println(finished
                ? "Well done, the player won first place!"
                : "Oh no, the player got lost on the track!");
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                sb.append(symbol);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }


    private static int getPosition(char[][] matrix, int currentPosition, int step) {
        int nextPosition = currentPosition + step;
        if (nextPosition < 0) {
            nextPosition = matrix.length - 1;
        } else if (nextPosition > matrix.length - 1) {
            nextPosition = 0;
        }
        return nextPosition;
    }

    private static int[] fillMatrixAndGetCoordinates(char[][] matrix, Scanner scanner) {
        int[] coordinates = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = line.charAt(col);
                matrix[row][col] = symbol;
                if (symbol == PLAYER) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}
