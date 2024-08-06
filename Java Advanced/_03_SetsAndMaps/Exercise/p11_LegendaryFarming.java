package _03_SetsAndMaps.Exercise;

import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class p11_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        String legendaryItem = null;

        while (legendaryItem == null) {
            String[] input = scanner.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1];

                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);

                    if (keyMaterials.get(material) >= 250) {
                        legendaryItem = getLegendaryItem(material);
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        break;
                    }
                } else {
                    junkMaterials.put(material, junkMaterials.getOrDefault(material, 0) + quantity);
                }
            }
        }

        System.out.println(legendaryItem + " obtained!");

        keyMaterials.entrySet().stream()
                .sorted((a, b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        for (Map.Entry<String, Integer> entry : junkMaterials.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String getLegendaryItem(String material) {
        switch (material) {
            case "shards":
                return "Shadowmourne";
            case "fragments":
                return "Valanyr";
            case "motes":
                return "Dragonwrath";
            default:
                return "";
        }
    }
}
