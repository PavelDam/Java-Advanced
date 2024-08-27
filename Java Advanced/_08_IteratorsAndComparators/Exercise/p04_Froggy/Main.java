package _08_IteratorsAndComparators.Exercise.p04_Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] input = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Lake lake = new Lake(input);
        List<String> result = new ArrayList<>();

        for (Integer integer : lake) {
            result.add(String.valueOf(integer));
        }
        System.out.println(String.join(", ",result));

    }
}
