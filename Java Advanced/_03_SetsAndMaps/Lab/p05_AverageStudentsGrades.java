package _03_SetsAndMaps.Lab._02_Maps;

import java.util.*;

public class P05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> map = new TreeMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            }
            map.get(name).add(grade);
        }

        map.entrySet().stream().forEach(e -> {
            double averageGrade = 0;
            for (int i = 0; i < e.getValue().size(); i++) {
                averageGrade += e.getValue().get(i);
            }
            averageGrade = averageGrade / e.getValue().size();
            System.out.print(e.getKey() + " -> ");
            e.getValue().forEach(value -> System.out.printf("%.2f ", value));
            System.out.printf("(avg: %.2f)%n", averageGrade);
        });
    }
}
