package _Exams.Exam_25June2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02_StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> commandsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).forEach(commandsQueue::offer);

        String[][] matrix = new String[size][size];

        int[] coordinates = fillMatrixAndGetCoordinates(matrix, scanner);
        int row = coordinates[0];
        int col = coordinates[1];

        int pocket = 0;
        boolean getCaught = false;

        while (!commandsQueue.isEmpty()) {
            String command = commandsQueue.poll();


            int newRow = 0;
            int newCol = 0;
            switch (command) {
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
            if (isInBounds(matrix, row + newRow, col + newCol)) {
                matrix[row][col] = "+";
                row += newRow;
                col += newCol;
            } else {
                System.out.println("You cannot leave the town, there is police outside!");
                continue;
            }
            String symbol = matrix[row][col];

            if (symbol.equals("$")) {
                matrix[row][col] = "+";
                int stolenMoney = row * col;
                pocket += stolenMoney;
                System.out.printf("You successfully stole %d$.%n", stolenMoney);

            } else if (symbol.equals("P")) {
                getCaught = true;
                matrix[row][col] = "#";
                break;
            }


        }
        if (getCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", pocket);
        } else {
            matrix[row][col] = "D";
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", pocket);
        }
        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                builder.append(matrix[row][col]).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        System.out.println(builder.toString().trim());
    }

    private static boolean isInBounds(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[] fillMatrixAndGetCoordinates(String[][] matrix, Scanner scanner) {
        int[] coordinates = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = line.charAt(col);
                matrix[row][col] = String.valueOf(symbol);
                if (symbol == 'D') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}
