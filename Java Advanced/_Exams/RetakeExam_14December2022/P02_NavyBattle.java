package _Exams.RetakeExam_14December2022;

import java.util.Scanner;

public class P02_NavyBattle {
    private static final char SUBMARINE = 'S';
    private static final char EMPTY_CELL = '-';
    private static final char MINE = '*';
    private static final int TOTAL_MINES = 3;
    private static final char BATTLE_CRUISER = 'C';
    private static final int COUNT_BATTLE_CRUISER = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] battlefield = new char[size][size];

        int[] submarineCoordinates = fillBattlefieldAndGetCoordinates(battlefield, scanner);
        int row = submarineCoordinates[0];
        int col = submarineCoordinates[1];

        int minesHit = 0;
        boolean lostBattle = false;

        int destroyedShips = 0;
        boolean winBattle = false;

        while (!lostBattle && !winBattle) {
            battlefield[row][col] = EMPTY_CELL;
            String command = scanner.nextLine();
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
            char position = battlefield[row][col];
            if (position == MINE) {

                minesHit++;
                if (minesHit == TOTAL_MINES) {
                    battlefield[row][col] = SUBMARINE;
                    lostBattle = true;
                }
            } else if (position == BATTLE_CRUISER) {
                battlefield[row][col] = SUBMARINE;
                destroyedShips++;
                if (destroyedShips == COUNT_BATTLE_CRUISER) {
                    winBattle = true;
                }
            } else {
                battlefield[row][col] = SUBMARINE;
            }
        }

        System.out.println(winBattle
                ? "Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!"
                : String.format("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!", row, col));
        printBattlefield(battlefield);
    }

    private static void printBattlefield(char[][] battlefield) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < battlefield.length; row++) {
            for (int col = 0; col < battlefield[row].length; col++) {
                char symbol = battlefield[row][col];
                sb.append(symbol);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }


    private static int[] fillBattlefieldAndGetCoordinates(char[][] battlefield, Scanner scanner) {
        int[] coordinates = new int[2];

        for (int row = 0; row < battlefield.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < battlefield[row].length; col++) {
                char symbol = line.charAt(col);
                battlefield[row][col] = symbol;
                if (symbol == SUBMARINE) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}
