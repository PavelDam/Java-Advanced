package _03_SetsAndMaps.Lab._02_Maps;

import java.util.*;

public class P07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);
        }

//        for (String continent : map.keySet()) {
//            System.out.println(continent + ":");
//            Map<String, List<String>> countryMap = map.get(continent);
//            for (String country : countryMap.keySet()) {
//                System.out.print("  " + country + " -> ");
//                List<String> cities = countryMap.get(country);
//                String output = String.join(", ", cities);
//                System.out.println(output);
//            }
//        }
        map.forEach((continent, countryMap) -> {
            System.out.println(continent + ":");
            countryMap.forEach((country, cities) -> {
                System.out.print("  " + country + " -> ");
                String output = String.join(", ", cities);
                System.out.println(output);
            });
        });

    }
}
