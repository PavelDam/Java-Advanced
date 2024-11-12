package _04_InterfacesAndAbstraction.Exercise.P05_Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbersArr = getSplitInput(scanner);

        List<String> urlsArr = getSplitInput(scanner);

        Smartphone smartphone = new Smartphone(numbersArr, urlsArr);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());

    }

    private static List<String> getSplitInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
    }
}
