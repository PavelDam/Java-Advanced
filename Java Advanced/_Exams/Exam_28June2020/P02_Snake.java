package _Exams.Exam_28June2020;

import java.util.Scanner;

public class P02_Snake {
    private static final int WINNING_FOOD_QUANTITY = 10;
    private static final char EMPTY_CELL = '.';
    private static final char SNAKE_CELL = 'S';
    private static final char BURROW_CELL = 'B';
    private static final char FOOD_CELL = '*';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int[] coordinates = fillMatrixAndGetCoordinates(matrix, scanner);
        int row = coordinates[0];
        int col = coordinates[1];

        int foodQuantity = 0;
        boolean inTerritory = true;

        while (inTerritory && foodQuantity < WINNING_FOOD_QUANTITY) {
            String command = scanner.nextLine();
            matrix[row][col] = EMPTY_CELL;

            int[] movement = getMovement(command);
            int newRow = movement[0];
            int newCol = movement[1];

            inTerritory = isInBounds(matrix, row, col, newRow, newCol);

            if (inTerritory) {
                row += newRow;
                col += newCol;
                char symbol = matrix[row][col];
                if (symbol == FOOD_CELL) {
                    foodQuantity++;
                } else if (symbol == BURROW_CELL) {
                    matrix[row][col] = EMPTY_CELL;
                    int[] newCoordinates = getNewBurrowCoordinates(coordinates, row, col);
                    row = newCoordinates[0];
                    col = newCoordinates[1];
                }
                matrix[row][col] = SNAKE_CELL;
            }
        }

        if (foodQuantity == WINNING_FOOD_QUANTITY) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }

        System.out.printf("Food eaten: %d%n", foodQuantity);

        printMatrix(matrix);
    }

    private static int[] getNewBurrowCoordinates(int[] coordinates, int row, int col) {
        if (row == coordinates[2] && col == coordinates[3]) {
            return new int[]{coordinates[4], coordinates[5]};
        } else {
            return new int[]{coordinates[2], coordinates[3]};
        }
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

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int col, int newRow, int newCol) {
        return isRowInBounds(matrix, row, newRow) && isColInBounds(matrix, col, newCol);
    }

    private static boolean isRowInBounds(char[][] matrix, int row, int newRow) {
        return row + newRow >= 0 && row + newRow < matrix.length;
    }

    private static boolean isColInBounds(char[][] matrix, int col, int newCol) {
        return col + newCol >= 0 && col + newCol < matrix.length;
    }

    private static int[] fillMatrixAndGetCoordinates(char[][] matrix, Scanner scanner) {
        int[] coordinates = new int[6];
        int burrowCounter = 0;
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = line.charAt(col);
                matrix[row][col] = symbol;
                if (symbol == SNAKE_CELL) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
                if (symbol == BURROW_CELL && burrowCounter == 0) {
                    coordinates[2] = row;
                    coordinates[3] = col;
                    burrowCounter++;
                } else if (symbol == BURROW_CELL && burrowCounter == 1) {
                    coordinates[4] = row;
                    coordinates[5] = col;
                }
            }
        }
        return coordinates;
    }
}