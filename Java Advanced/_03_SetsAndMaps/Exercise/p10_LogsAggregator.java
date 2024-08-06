package _03_SetsAndMaps.Exercise;

import java.util.*;

import static java.util.Map.Entry.comparingByKey;

public class P10_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> durationMap = new TreeMap<>();
        Map<String, Set<String>> ipMap = new HashMap<>();

        for (int i = 0; i < count; i++) {

            String[] inputArr = scanner.nextLine().split(" ");
            String ip = inputArr[0];
            String name = inputArr[1];
            int duration = Integer.parseInt(inputArr[2]);

            if (!durationMap.containsKey(name)) {
                durationMap.put(name, 0);
            }
            durationMap.put(name, durationMap.get(name) + duration);

            if (!ipMap.containsKey(name)) {
                ipMap.put(name, new TreeSet<>());
            }
            ipMap.get(name).add(ip);

        }
        for (String durationName : durationMap.keySet()) {
            System.out.printf("%s: %d ", durationName, durationMap.get(durationName));
            System.out.println(ipMap.get(durationName));
        }
    }
}
