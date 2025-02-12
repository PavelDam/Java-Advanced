package _08_ExceptionAndErrorHandling.P01_NumberInRange;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rangeArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.printf("Range: [%d...%d]%n", rangeArr[0], rangeArr[1]);
        boolean isValidInput = false;

        while (!isValidInput) {
            String input = scanner.nextLine();
            Optional<Integer> number = Optional.empty();

            try {
                number = Optional.of(Integer.parseInt(input));
            } catch (NumberFormatException ignored) {
            }

            String output = "Invalid number: " + input;

            if (number.isPresent() && isInBounds(rangeArr, number.get())) {
                output = "Valid number: " + number.get();
                isValidInput = true;
            }
            System.out.println(output);
        }
    }

    private static boolean isInBounds(int[] rangeArr, int number) {
        return number >= rangeArr[0] && number <= rangeArr[1];
    }
}
