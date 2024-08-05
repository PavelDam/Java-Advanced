package _03_SetsAndMaps.Lab._02_Maps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            double currentNum = input[i];
            if (!map.containsKey(currentNum)) {
                map.put(currentNum, 1);
            } else {
                map.put(currentNum, map.get(currentNum) + 1);
            }
        }
        map.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
