package _03_SetsAndMaps.Lab._01_Sets;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> set = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] arr = input.split(", ");
            String command = arr[0];
            String number = arr[1];

            switch (command) {

                case "IN":
                    set.add(number);
                    break;
                case "OUT":
                    set.remove(number);
                    break;
            }
            input = scanner.nextLine();
        }

        String output = set.isEmpty()
                ? "Parking Lot is Empty"
                : String.join(System.lineSeparator(), set);

        System.out.println(output);

    }
}
