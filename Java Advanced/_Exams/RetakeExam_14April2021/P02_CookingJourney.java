package _Exams.RetakeExam_14April2021;

import java.util.Scanner;

public class P02_CookingJourney {
    private static final char POSITION = 'S';
    private static final char PILLAR = 'P';
    private static final char EMPTY_POSITION = '-';
    private static final int GOAL = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int[] coordinates = fillMatrixAndGetCoordinates(matrix, scanner);
        int row = coordinates[0];
        int col = coordinates[1];
        boolean inPastryShop = true;
        int money = 0;
        while (inPastryShop && money < GOAL) {

            char currentSymbol = matrix[row][col];
            matrix[row][col] = EMPTY_POSITION;
            String command = scanner.nextLine();

            int[] move = move(matrix, command);
            int stepRow = move[0];
            int stepCol = move[1];
            inPastryShop = isInBounds(matrix, row + stepRow, col + stepCol);

            if (inPastryShop) {
                row += stepRow;
                col += stepCol;
                char symbol = matrix[row][col];
                if (Character.isDigit(symbol)) {
                    money += Integer.parseInt(String.valueOf(symbol));
                    matrix[row][col] = POSITION;
                } else if (symbol == PILLAR) {
                    matrix[row][col] = EMPTY_POSITION;
                    int[] pillarCoordinates = getPillarCoordinates(matrix);
                    row = pillarCoordinates[0];
                    col = pillarCoordinates[1];
                    matrix[row][col] = POSITION;
                }
            }
        }
        if (!inPastryShop) {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        if (money >= GOAL) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);
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

    private static int[] getPillarCoordinates(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == PILLAR) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

    private static int[] move(char[][] matrix, String command) {
        int[] newMove = new int[]{0, 0};
        switch (command) {
            case "up":
                newMove[0]--;
                break;
            case "down":
                newMove[0]++;
                break;
            case "left":
                newMove[1]--;
                break;
            case "right":
                newMove[1]++;
                break;

        }
        return newMove;
    }


    private static int[] fillMatrixAndGetCoordinates(char[][] matrix, Scanner scanner) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = line.charAt(col);
                matrix[row][col] = symbol;
                if (symbol == POSITION) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}
