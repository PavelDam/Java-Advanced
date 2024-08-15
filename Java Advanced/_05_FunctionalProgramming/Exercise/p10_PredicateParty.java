package _05_FunctionalProgramming.Exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class p10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> peoplesList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String criteria = tokens[1];
            String filter = tokens[2];

            List<String> matchingNames = getMatchingNames(peoplesList, criteria, filter);

            switch (command) {
                case "Double":
                    peoplesList.addAll(matchingNames);
                    break;

                case "Remove":
                    peoplesList.removeAll(matchingNames);
                    break;
            }

            input = scanner.nextLine();
        }

        String result = peoplesList.isEmpty()
                ? "Nobody is going to the party!"
                : peoplesList.stream().sorted().collect(Collectors.joining(", ")) + " are going to the party!";
        System.out.println(result);
    }

    private static List<String> getMatchingNames(List<String> names, String criteria, String filter) {
        return names.stream()
                .filter(name -> isMatch(name, criteria, filter))
                .collect(Collectors.toList());
    }

    private static boolean isMatch(String name, String criteria, String filter) {
        switch (criteria) {
            case "StartsWith":
                return name.startsWith(filter);
            case "EndsWith":
                return name.endsWith(filter);
            case "Length":
                return name.length() == Integer.parseInt(filter);
            default:
                throw new IllegalArgumentException("Unknown filter " + filter);
        }
    }
}
