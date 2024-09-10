package _Exams.Exam_22October2022;

import java.util.Scanner;
import java.util.stream.IntStream;

public class P02_RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int rowPosition = 0;
        int colPosition = 0;

        String input = scanner.nextLine();

        boolean finished = false;
        int distance = 0;
        while (!input.equals("End")) {
            switch (input) {
                case "up":
                    rowPosition--;
                    break;
                case "down":
                    rowPosition++;
                    break;
                case "left":
                    colPosition--;
                    break;
                case "right":
                    colPosition++;
                    break;
            }
            if (matrix[rowPosition][colPosition].equals("T")) {
                matrix[rowPosition][colPosition] = ".";
                int[] newCoordinates = driveTrueTunnel(matrix, rowPosition, colPosition);
                rowPosition = newCoordinates[0];
                colPosition = newCoordinates[1];
                matrix[rowPosition][colPosition] = ".";
                distance += 30;
            } else {
                distance += 10;
            }
            if (matrix[rowPosition][colPosition].equals("F")) {
                finished = true;
                break;
            }
            input = scanner.nextLine();
        }
        matrix[rowPosition][colPosition] = "C";

        System.out.println(finished
                ? String.format("Racing car %s finished the stage!", carNumber)
                : String.format("Racing car %s DNF.", carNumber));
        System.out.printf("Distance covered %d km.%n", distance);

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String s : arr) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    private static int[] driveTrueTunnel(String[][] matrix, int row, int col) {
        int[] newCoordinates = new int[2];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                String symbol = matrix[r][c];
                if (symbol.equals("T") && r != row && c != col) {
                    newCoordinates[0] = r;
                    newCoordinates[1] = c;
                    return newCoordinates;
                }
            }
        }
        return null;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

}
