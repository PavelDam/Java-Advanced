package _03_SetsAndMaps.Lab._01_Sets;

import java.util.*;
import java.util.stream.Collectors;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> set = new TreeSet<>();
        while (!input.equals("PARTY")) {
            set.add(input);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")) {
            set.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(set.size());
        set.forEach(System.out::println);
    }
}
