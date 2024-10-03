package _01_WorkingWithAbstraction.Lab.P02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rectangle rectangle = createRectangle(scanner);

        int numberOfPointsToCheck = Integer.parseInt(scanner.nextLine());

        checkPoints(scanner, rectangle, numberOfPointsToCheck);
    }

    private static int[] reedArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static Rectangle createRectangle(Scanner scanner) {
        int[] rectangleCoordinates = reedArray(scanner);

        Point bottomLeft = new Point(rectangleCoordinates[0], rectangleCoordinates[1]);
        Point topRight = new Point(rectangleCoordinates[2], rectangleCoordinates[3]);

        return new Rectangle(bottomLeft, topRight);
    }

    private static void checkPoints(Scanner scanner, Rectangle rectangle, int numberOfPointsToCheck) {
        for (int i = 0; i < numberOfPointsToCheck; i++) {
            int[] pointCoordinates = reedArray(scanner);
            Point point = new Point(pointCoordinates[0], pointCoordinates[1]);

            System.out.println(rectangle.contains(point));
        }
    }
}
