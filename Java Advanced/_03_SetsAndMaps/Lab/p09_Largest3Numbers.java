package _03_SetsAndMaps.Lab._02_Maps;

import java.util.*;
import java.util.stream.Collectors;

public class P09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted((a, b) -> Integer.compare(b, a))
                .collect(Collectors.toList());


        for (int i = 0; i < 3; i++) {

            try {
                System.out.print(list.get(i) + " ");
            } catch (IndexOutOfBoundsException e) {
                return;
            }

        }
    }
}
