package _Exams.Exam_26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02_Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> commands = Arrays.stream(scanner.nextLine().split(", "))
                .collect(ArrayDeque::new, ArrayDeque::offer, ArrayDeque::addAll);

        char[][] matrix = new char[size][size];

        int[] startCoordinatesArr = fillMatrixAndGetStartCoordinates(matrix, scanner);
        int row = startCoordinatesArr[0];
        int col = startCoordinatesArr[1];
        int food = startCoordinatesArr[2];
        int length = 1;

        boolean getKilled = false;
        while (!commands.isEmpty() && food != 0) {
            String command = commands.poll();

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
            row = getPosition(matrix, row, newRow);
            col = getPosition(matrix, col, newCol);

            char symbol = matrix[row][col];
            if (symbol == 'f') {
                length++;
                food--;
                continue;
            }
            if (symbol == 'e') {
                getKilled = true;
                break;
            }
        }

        if (getKilled) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.print(food == 0 ? String.format("You win! Final python length is %d", length)
                    : String.format("You lose! There is still %d food to be eaten.", food));
        }
    }

    private static int getPosition(char[][] matrix, int currentPosition, int step) {
        int position = currentPosition + step;

        if (position < 0) {
            position = matrix.length - 1;
        } else if (position > matrix.length - 1) {
            position = 0;
        }
        return position;
    }

    private static int[] fillMatrixAndGetStartCoordinates(char[][] matrix, Scanner scanner) {
        int[] coordinates = new int[3];
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = line.charAt(col);
                matrix[row][col] = symbol;
                if (symbol == 's') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
                if (symbol == 'f') {
                    coordinates[2]++;
                }
            }
        }
        return coordinates;
    }


}
