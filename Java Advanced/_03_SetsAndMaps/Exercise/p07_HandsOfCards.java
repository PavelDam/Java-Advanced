package _03_SetsAndMaps.Exercise;

import java.text.ParseException;
import java.util.*;

public class P07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Set<String>> map = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] inputArr = input.split(": ");
            String name = inputArr[0];
            String[] cards = inputArr[1].split(", ");

            if (!map.containsKey(name)) {
                map.put(name, new LinkedHashSet<>());
            }
            Set<String> cardSet = map.get(name);
            Collections.addAll(cardSet, cards);

            input = scanner.nextLine();
        }

        for (String name : map.keySet()) {

            int points = getPoints(map, name);
            System.out.printf("%s: %d%n", name, points);
        }
    }

    private static int getPoints(Map<String, Set<String>> map, String name) {
        Set<String> currentPlayerCards = map.get(name);
        int totalPoints = 0;
        for (String currentCard : currentPlayerCards) {

            int multiplier = 0;
            String paint = currentCard.substring(currentCard.length() - 1);
            switch (paint) {
                case "C":
                    multiplier = 1;
                    break;
                case "D":
                    multiplier = 2;
                    break;
                case "H":
                    multiplier = 3;
                    break;
                case "S":
                    multiplier = 4;
                    break;
            }
            String points = currentCard.substring(0, currentCard.length() - 1);
            int cardPoints = 0;
            try {
                cardPoints = Integer.parseInt(points);
            } catch (Exception e) {
                switch (points) {
                    case "J":
                        cardPoints = 11;
                        break;
                    case "Q":
                        cardPoints = 12;
                        break;
                    case "K":
                        cardPoints = 13;
                        break;
                    case "A":
                        cardPoints = 14;
                        break;
                }
            }
            totalPoints += cardPoints * multiplier;
        }
        return totalPoints;
    }
}
