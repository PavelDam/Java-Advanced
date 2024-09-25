package _Exams.RetakeExam_17Dec2019;

import java.util.Scanner;

public class P02_PresentDelivery {
    private static final char SANTA = 'S';
    private static final char NAUGHTY_KID = 'X';
    private static final char NICE_KID = 'V';
    private static final char COOKIE = 'C';
    private static final char EMPTY = '-';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPresents = Integer.parseInt(scanner.nextLine());

        int presentsCount = totalPresents;
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        int[] coordinates = fillMatrixAndGetCoordinates(matrix, scanner);
        int row = coordinates[0];
        int col = coordinates[1];
        int kidCounter = coordinates[2];

        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {
            matrix[row][col] = EMPTY;

            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;

            }
            char symbol = matrix[row][col];
            if (symbol == NICE_KID) {
                presentsCount--;
                kidCounter--;
            } else if (symbol == COOKIE) {
                int[] kidsAndPresents = checkForKids(matrix, row, col, presentsCount, kidCounter);
                presentsCount = kidsAndPresents[0];
                kidCounter = kidsAndPresents[1];
            }
            matrix[row][col] = SANTA;
            if (presentsCount == 0) {
                break;
            }
            command = scanner.nextLine();
        }
        if (presentsCount < 1) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);
        if (kidCounter == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", coordinates[2]);
        } else {
            System.out.printf("No presents for %d nice kid/s.", kidCounter);
        }

    }

    private static void printMatrix(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                sb.append(symbol).append(" ");
            }
            if (row < matrix.length - 1) {
                sb.append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }

    private static int[] checkForKids(char[][] matrix, int row, int col, int presentsCount, int kidCounter) {
        int[] counterArr = new int[2];
        counterArr = checkAndRemoveKid(matrix, row - 1, col, counterArr);
        counterArr = checkAndRemoveKid(matrix, row + 1, col, counterArr);
        counterArr = checkAndRemoveKid(matrix, row, col - 1, counterArr);
        counterArr = checkAndRemoveKid(matrix, row, col + 1, counterArr);
        return counterArr;
    }

    private static int[] checkAndRemoveKid(char[][] matrix, int row, int col, int[] counterArr) {
        if ((matrix[row][col] == NICE_KID || matrix[row][col] == NAUGHTY_KID)) {
            if (matrix[row][col] == NICE_KID) {
                counterArr[1]--;
            }
            matrix[row][col] = EMPTY;
            counterArr[0]--;
        }
        return counterArr;
    }

    private static int[] fillMatrixAndGetCoordinates(char[][] matrix, Scanner scanner) {
        int[] coordinates = new int[3];
        int kidCounter = 0;
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = line.charAt(col);
                matrix[row][col] = symbol;
                if (symbol == SANTA) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
                if (symbol == NICE_KID) {
                    kidCounter++;
                }
            }
        }
        coordinates[2] = kidCounter;
        return coordinates;
    }
}
