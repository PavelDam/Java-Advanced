package _01_WorkingWithAbstraction.Exercise.P05_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] galaxyDimension = getCoordinates(scanner);
        int rows = galaxyDimension[0];
        int cols = galaxyDimension[1];

        Galaxy galaxy = new Galaxy(rows, cols);
        galaxy.create();

        String command = scanner.nextLine();
        long starsCollected = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinates = getJediCoordinates(command);
            Jedi jedi = new Jedi(jediCoordinates);

            int[] evilCoordinates = getCoordinates(scanner);
            Evil evil = new Evil(evilCoordinates);

            evil.move();
            starsCollected += jedi.move();

            command = scanner.nextLine();
        }

        System.out.println(starsCollected);

    }

    private static int[] getJediCoordinates(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[] getCoordinates(Scanner scanner) {
        return getJediCoordinates(scanner.nextLine());
    }
}
