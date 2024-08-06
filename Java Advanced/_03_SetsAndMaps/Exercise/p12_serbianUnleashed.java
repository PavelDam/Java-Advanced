package _03_SetsAndMaps.Exercise;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class p12_serbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> venueData = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }

            String regex = "^(?<singer>\\w+( \\w+){0,2}) @(?<venue>\\w+( \\w+){0,2}) (?<price>\\d+) (?<count>\\d+)$";
            if (input.matches(regex)) {
                String[] parts = input.split(" @");
                if (parts.length != 2) {
                    continue;
                }
                String singer = parts[0];
                String[] venueAndSales = parts[1].split(" ");
                if (venueAndSales.length < 3) {
                    continue;
                }

                String venue = venueAndSales[0];
                for (int i = 1; i < venueAndSales.length - 2; i++) {
                    venue += " " + venueAndSales[i];
                }


                int ticketPrice = Integer.parseInt(venueAndSales[venueAndSales.length - 2]);
                int ticketCount = Integer.parseInt(venueAndSales[venueAndSales.length - 1]);
                long totalMoney = (long) ticketPrice * ticketCount;

                venueData.putIfAbsent(venue, new LinkedHashMap<>());
                venueData.get(venue).putIfAbsent(singer, 0L);
                venueData.get(venue).put(singer, venueData.get(venue).get(singer) + totalMoney);

            }
        }

        for (String venue : venueData.keySet()) {
            System.out.println(venue);
            LinkedHashMap<String, Long> singersData = venueData.get(venue);

            singersData.entrySet()
                    .stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .forEach(entry -> System.out.println("#  " + entry.getKey() + " -> " + entry.getValue()));
        }
    }
}

