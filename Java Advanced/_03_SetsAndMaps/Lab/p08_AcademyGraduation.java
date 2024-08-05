package _03_SetsAndMaps.Lab._02_Maps;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.stream.Collectors;

public class P08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> map = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();

            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).addAll(Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).boxed()
                    .collect(Collectors.toList()));
        }
        map.forEach((name, grades) -> {
            double sum = 0;
            for (Double aDouble : grades) {
                sum += aDouble;
            }
            sum = sum / grades.size();
            System.out.println(name + " is graduated with " + sum);
        });


    }
}
