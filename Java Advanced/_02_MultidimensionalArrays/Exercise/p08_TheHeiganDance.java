package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P08_TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerRow = 7;
        int playerCol = 7;

        int playerPoints = 18500;
        double heiganPoints = 3000000;

        double damage = Double.parseDouble(scanner.nextLine());


        String lastSpell = "";

        while (true) {

            if (playerPoints >= 0) {
                heiganPoints -= damage;
            }

            if (lastSpell.equals("Cloud")) {
                playerPoints -= 3500;
            }

            if (heiganPoints <= 0 || playerPoints <= 0) {
                break;
            }

            String[] input = scanner.nextLine().split(" ");
            String currentSpell = input[0];
            int hitRow = Integer.parseInt(input[1]);
            int hitCol = Integer.parseInt(input[2]);

            if (isInDamageArea(hitRow, hitCol, playerRow, playerCol)) {
                if (!isInDamageArea(hitRow, hitCol, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {
                    playerRow--;
                    lastSpell = "";
                } else if (!isInDamageArea(hitRow, hitCol, playerRow, playerCol + 1) && !isWall(playerCol + 1)) {
                    playerCol++;
                    lastSpell = "";
                } else if (!isInDamageArea(hitRow, hitCol, playerRow + 1, playerCol) && !isWall(playerRow + 1)) {
                    playerRow++;
                    lastSpell = "";
                } else if (!isInDamageArea(hitRow, hitCol, playerRow, playerCol - 1) && !isWall(playerCol - 1)) {
                    playerCol--;
                    lastSpell = "";
                } else {
                    if (currentSpell.equals("Cloud")) {
                        playerPoints -= 3500;
                        lastSpell = "Cloud";
                    } else if (currentSpell.equals("Eruption")) {
                        playerPoints -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }
        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        if (heiganPoints <= 0) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %d%n", playerPoints);
        } else if (playerPoints <= 0) {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
            System.out.printf("Player: Killed by %s%n", lastSpell);
        }
        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static boolean isInDamageArea(int targetRow, int targetCol, int moveRow, int moveCol) {
        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1)
                && (targetCol - 1 <= moveCol && moveCol <= targetCol + 1));
    }

    private static boolean isWall(int moveCell) {
        return moveCell < 0 || moveCell >= 15;
    }
}
