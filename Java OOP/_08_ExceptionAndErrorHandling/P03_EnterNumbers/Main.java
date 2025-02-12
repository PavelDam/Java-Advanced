package _08_ExceptionAndErrorHandling.P03_EnterNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = 1;
        int end = 100;

        List<Integer> numbersList = new ArrayList<>();

        while (numbersList.size() < 10) {

            try {
                start = readNumber(start, end, scanner);
                numbersList.add(start);
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid Number!");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print(numbersList.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static int readNumber(int start, int end, Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());

        if (number <= start || number >= end) {
            throw new IllegalStateException("Your number is not in range " + start + " - " + end + "!");
        }
        return number;
    }
}
