package _Exams.Exam_22Feb2020;

import java.util.Scanner;

public class P02_ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int[] playerPosition = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'f') {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                }
            }
        }

        boolean finished = false;
        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            int[] newPosition = calculateNewPosition(matrix, command, playerPosition);
            char symbol = matrix[newPosition[0]][newPosition[1]];

            if (symbol == 'B') {
                newPosition = calculateNewPosition(matrix, command, newPosition);
            } else if (symbol == 'T') {
                newPosition = playerPosition;
            }

            matrix[playerPosition[0]][playerPosition[1]] = '-';
            matrix[newPosition[0]][newPosition[1]] = 'f';

            playerPosition = newPosition;

            if (symbol == 'F') {
                finished = true;
                break;
            }
        }

        System.out.println(finished ? "Player won!" : "Player lost!");
        printMatrix(matrix);
    }

    private static int[] calculateNewPosition(char[][] matrix, String command, int[] position) {
        int row = position[0];
        int col = position[1];

        switch (command) {
            case "up":
                row = (row - 1 + matrix.length) % matrix.length;
                break;
            case "down":
                row = (row + 1) % matrix.length;
                break;
            case "left":
                col = (col - 1 + matrix[0].length) % matrix[0].length;
                break;
            case "right":
                col = (col + 1) % matrix[0].length;
                break;
        }

        return new int[]{row, col};
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(new String(row));
        }
    }
}
