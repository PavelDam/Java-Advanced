package _Exams.RetakeExam_13April2022;

import java.util.Scanner;

public class P02_Armory {
    private static final char ARMY_OFFICER = 'A';
    private static final char MIRROR = 'M';
    private static final int GOLD_COINS = 65;
    private static final char EMPTY_CELL = '-';


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int[] officerCoordinates = fillMatrixAndGetCoordinates(matrix, scanner);
        int row = officerCoordinates[0];
        int col = officerCoordinates[1];

        boolean inArmory = true;
        int coins = 0;
        while (inArmory && coins < GOLD_COINS) {
            matrix[row][col] = EMPTY_CELL;
            String command = scanner.nextLine();
            int[] movement = getMovement(command);
            int newRow = movement[0];
            int newCol = movement[1];

            inArmory = isInBounds(matrix, row, col, newRow, newCol);

            if (inArmory) {
                row += newRow;
                col += newCol;

                char symbol = matrix[row][col];
                if (Character.isDigit(symbol)) {
                    coins += Integer.parseInt(String.valueOf(symbol));
                    matrix[row][col] = EMPTY_CELL;
                } else if (symbol == MIRROR) {
                    matrix[row][col] = EMPTY_CELL;
                    int[] mirrorCoordinates = getMirrorCoordinates(matrix, row, col, MIRROR);
                    row = mirrorCoordinates[0];
                    col = mirrorCoordinates[1];
                }
            } else {
                break;
            }
            matrix[row][col] = ARMY_OFFICER;
        }
        System.out.println(inArmory
                ? "Very nice swords, I will come back for more!"
                : "I do not need more swords!");

        System.out.printf("The king paid %d gold coins.%n", coins);

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

    private static int[] getMirrorCoordinates(char[][] matrix, int row, int col, char mirror) {
        int[] mirrorCoordinates = new int[2];
        for (int currentRow = 0; currentRow < matrix.length; currentRow++) {
            for (int currentCol = 0; currentCol < matrix[currentRow].length; currentCol++) {
                char symbol = matrix[currentRow][currentCol];
                if (symbol == mirror) {
                    mirrorCoordinates[0] = currentRow;
                    mirrorCoordinates[1] = currentCol;
                }
            }
        }
        return mirrorCoordinates;
    }


    private static boolean isInBounds(char[][] matrix, int row, int col, int newRow, int newCol) {

        return row + newRow >= 0 && row + newRow < matrix.length && col + newCol >= 0 && col + newCol < matrix.length;
    }

    private static int[] getMovement(String command) {
        int[] movement = new int[]{0, 0};
        switch (command) {
            case "up":
                movement[0] = -1;
                break;
            case "down":
                movement[0] = 1;
                break;
            case "left":
                movement[1] = -1;
                break;
            case "right":
                movement[1] = 1;
                break;
        }
        return movement;

    }

    private static int[] fillMatrixAndGetCoordinates(char[][] matrix, Scanner scanner) {
        int[] coordinates = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = line.charAt(col);
                matrix[row][col] = symbol;
                if (symbol == ARMY_OFFICER) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}
