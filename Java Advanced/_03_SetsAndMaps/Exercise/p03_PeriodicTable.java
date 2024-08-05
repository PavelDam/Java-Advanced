package _03_SetsAndMaps.Exercise;

import java.util.*;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lineCounter = Integer.parseInt(scanner.nextLine());

        Set<String> set = new TreeSet<>();

        for (int i = 0; i < lineCounter; i++) {
            String input = scanner.nextLine();
            Collections.addAll(set, (input.split(" ")));
        }
        set.forEach(element -> System.out.print(element + " "));
    }
}
