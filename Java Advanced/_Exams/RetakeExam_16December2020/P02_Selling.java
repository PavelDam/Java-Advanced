package _Exams.RetakeExam_16December2020;

import java.util.Scanner;

public class P02_Selling {
    private static final char POSITION = 'S';
    private static final char PILLAR = 'O';
    private static final char EMPTY_CELL = '-';
    private static final int MONEY_GOAL = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] bakery = new char[size][size];

        int[] coordinates = fillBakeryAndGetCoordinates(bakery, scanner);
        int row = coordinates[0];
        int col = coordinates[1];

        boolean inBakery = true;
        int money = 0;
        while (inBakery && money < MONEY_GOAL) {
            bakery[row][col] = EMPTY_CELL;
            String command = scanner.nextLine();
            int[] moveArr = move(command);
            int stepRow = moveArr[0];
            int stepCol = moveArr[1];

            inBakery = isInBounds(bakery, row + stepRow, col + stepCol);
            if (inBakery) {
                row += stepRow;
                col += stepCol;
                char symbol = bakery[row][col];

                if (Character.isDigit(symbol)) {
                    money += Integer.parseInt(String.valueOf(symbol));

                } else if (symbol == PILLAR) {
                    bakery[row][col] = EMPTY_CELL;
                    if (row == coordinates[2] && col == coordinates[3]) {
                        row = coordinates[4];
                        col = coordinates[5];
                    } else {
                        row = coordinates[2];
                        col = coordinates[3];
                    }
                }
                bakery[row][col] = POSITION;
            }
        }
        System.out.println(inBakery
                ? "Good news! You succeeded in collecting enough money!"
                : "Bad news, you are out of the bakery.");
        System.out.printf("Money: %d%n", money);
        printBakery(bakery);
    }

    private static void printBakery(char[][] bakery) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {
                char symbol = bakery[row][col];
                sb.append(symbol);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }


    private static boolean isInBounds(char[][] bakery, int row, int col) {
        return row >= 0 && row < bakery.length && col >= 0 && col < bakery.length;
    }

    private static int[] move(String command) {
        int[] stepsArr = new int[]{0, 0};
        switch (command) {
            case "up":
                stepsArr[0]--;
                break;
            case "down":
                stepsArr[0]++;
                break;
            case "left":
                stepsArr[1]--;
                break;
            case "right":
                stepsArr[1]++;
                break;
        }
        return stepsArr;
    }

    private static int[] fillBakeryAndGetCoordinates(char[][] bakery, Scanner scanner) {
        int[] coordinates = new int[6];
        int pillarCount = 0;
        for (int row = 0; row < bakery.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < bakery[row].length; col++) {
                char symbol = line.charAt(col);
                bakery[row][col] = symbol;
                if (symbol == POSITION) {
                    coordinates[0] = row;
                    coordinates[1] = col;

                } else if (symbol == PILLAR && pillarCount == 0) {
                    coordinates[2] = row;
                    coordinates[3] = col;
                    pillarCount++;
                } else if (symbol == PILLAR && pillarCount == 1) {
                    coordinates[4] = row;
                    coordinates[5] = col;
                }
            }
        }

        return coordinates;
    }
}
