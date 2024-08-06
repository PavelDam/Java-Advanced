package _03_SetsAndMaps.Exercise;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class P09_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> map = new HashMap<>();
        Map<String, BigDecimal> totalMap = new HashMap<>();

        while (!input.equals("report")) {
            String[] inputArr = input.split("\\|");

            String city = inputArr[0];
            String country = inputArr[1];
            int cityPopulation = Integer.parseInt(inputArr[2]);

            if (!map.containsKey(country)) {
                map.put(country, new TreeMap<>());
            }
            Map<String, Integer> cityMap = map.get(country);
            cityMap.put(city, cityPopulation);
            map.put(country, cityMap);

            if (!totalMap.containsKey(country)) {
                totalMap.put(country, BigDecimal.valueOf(cityPopulation));
            } else {
                BigDecimal currentPopulation = totalMap.get(country);
                totalMap.put(country, currentPopulation.add(BigDecimal.valueOf(cityPopulation)));
            }

            input = scanner.nextLine();
        }
        Map<String, BigDecimal> sortedMap = totalMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println();

        map.forEach((key, innerMap) -> {
            Map<String, Integer> sortedInnerMap = innerMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));
            map.put(key, sortedInnerMap);
        });
        for (String country : sortedMap.keySet()) {
            System.out.printf("%s (total population: %.0f)%n", country, sortedMap.get(country));
            Map<String, Integer> cityMap = map.get(country);

            for (String city: cityMap.keySet()) {
                System.out.printf("=>%s: %d%n",city,cityMap.get(city));
            }
        }

    }
}
