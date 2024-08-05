package _03_SetsAndMaps.Exercise;

import java.util.*;

public class P02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] countsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstSetCount = countsArr[0];
        int secondSetCount = countsArr[1];
        Set<Integer> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < firstSetCount; i++) {
            int inputNumber = scanner.nextInt();
            firstSet.add(inputNumber);
        }
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < secondSetCount; i++) {
            int inputNumber = scanner.nextInt();
            secondSet.add(inputNumber);
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(element -> System.out.print(element + " "));
    }
}
