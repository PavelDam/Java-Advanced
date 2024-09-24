package _Exams.RetakeExam_15December2021;

import java.util.Scanner;

public class P02_ThroneConquering {
    private static final char PARIS = 'P';
    private static final char PARIS_DEAD = 'X';
    private static final char SPARTAN = 'S';
    private static final char HELEN = 'H';
    private static final char EMPTY_SPACE = '-';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        int[] coordinates = fillFieldAndGetCoordinates(field, scanner);
        int row = coordinates[0];
        int col = coordinates[1];

        boolean parisIsAlive = true;
        boolean findHelen = false;

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);
            field[spartanRow][spartanCol] = SPARTAN;

            int[] move = getMove(field, command);
            int stepRow = move[0];
            int stepCol = move[1];
            boolean inBounds = isInBounds(field, row + stepRow, col + stepCol);
            parisEnergy--;

            if (inBounds) {
                field[row][col] = EMPTY_SPACE;
                row += stepRow;
                col += stepCol;
                char symbol = field[row][col];

                if (symbol == SPARTAN) {
                    parisEnergy -= 2;
                    if (parisEnergy <= 0) {
                        field[row][col] = PARIS_DEAD;
                        parisIsAlive = false;
                        break;
                    } else {
                        field[row][col] = PARIS;
                    }
                } else if (symbol == HELEN) {
                    field[row][col] = EMPTY_SPACE;
                    findHelen = true;
                    break;
                } else {
                    field[row][col] = PARIS;
                }
            }
            if (parisEnergy <= 0) {
                field[row][col] = PARIS_DEAD;
                parisIsAlive = false;
            }

        }
        if (!parisIsAlive) {
            System.out.printf("Paris died at %d;%d.%n", row, col);
        }
        if (findHelen) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
        }
        printField(field);
    }

    private static void printField(char[][] field) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                sb.append(field[row][col]);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }

    private static boolean isInBounds(char[][] field, int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field.length;
    }

    private static int[] getMove(char[][] field, String command) {
        int[] coordinates = new int[]{0, 0};
        switch (command) {
            case "up":
                coordinates[0]--;
                break;
            case "down":
                coordinates[0]++;
                break;
            case "left":
                coordinates[1]--;
                break;
            case "right":
                coordinates[1]++;
                break;
        }
        return coordinates;
    }

    private static int[] fillFieldAndGetCoordinates(char[][] field, Scanner scanner) {
        int[] coordinates = new int[2];

        for (int row = 0; row < field.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < field[row].length; col++) {
                char symbol = line.charAt(col);
                field[row][col] = symbol;
                if (symbol == PARIS) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}
