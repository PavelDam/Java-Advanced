package _Exams.Exam_23October2021;

import java.util.Scanner;
import java.util.stream.IntStream;

public class P02_MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];


        fillMatrix(matrix, scanner);

        int[] coordinatesOfMouse = getCoordinates(matrix);
        int row = coordinatesOfMouse[0];
        int col = coordinatesOfMouse[1];

        int eatenCheese = 0;

        String input = scanner.nextLine();
        boolean goesOut = false;
        while (!input.equals("end")) {

            matrix[row][col] = '-';
            int[] move = moving(matrix, input, row, col);
            row = move[0];
            col = move[1];

            if (!isInBounds(matrix, row, col)) {
                goesOut = true;
                break;
            }

            char currentSymbol = matrix[row][col];
            if (currentSymbol == 'c') {
                eatenCheese++;
            }
            if (currentSymbol == 'B') {
                continue;
            }
            matrix[row][col] = 'M';
            input = scanner.nextLine();
        }

        if (goesOut) {
            System.out.println("Where is the mouse?");
        }

        System.out.print(eatenCheese < 5
                ? String.format("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese)
                : String.format("Great job, the mouse is fed %d cheeses!%n", eatenCheese));

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] moving(char[][] matrix, String input, int row, int col) {
        int[] moveArr = new int[2];
        switch (input) {
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
        moveArr[0] = row;
        moveArr[1] = col;
        return moveArr;
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        IntStream.range(0, matrix.length)
                .forEach(row ->
                        matrix[row] = scanner.nextLine().toCharArray()
                );
    }

    private static int[] getCoordinates(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    return coordinates;
                }
            }
        }
        return coordinates;
    }
}