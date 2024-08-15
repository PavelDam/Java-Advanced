package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (f, s) -> {
            if (f % 2 == 0 && s % 2 != 0) {
                return -1;
            } else if (f % 2 != 0 && s % 2 == 0) {
                return 1;
            }
            return f.compareTo(s);
        };
        inputList.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
