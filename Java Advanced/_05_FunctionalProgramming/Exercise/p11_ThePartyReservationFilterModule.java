package _05_FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        Set<String> filterSet = new HashSet<>();

        while (!input.equals("Print")) {

            fillFiltersSet(filterSet, input);

            input = scanner.nextLine();
        }

        managingList(inputList, filterSet);

        finalPrint(inputList);
    }

    private static void managingList(List<String> inputList, Set<String> filterSet) {
        filterSet.forEach(filter -> {
            Predicate<String> predicate = isMatch(filter);
            inputList.removeIf(predicate);
        });
    }

    private static void finalPrint(List<String> inputList) {
        Consumer<List<String>> printer = word -> {
            System.out.print(word.stream().collect(Collectors.joining(" ")));
        };
        printer.accept(inputList);
    }

    private static Predicate<String> isMatch(String filter) {
        String type = filter.split(";")[0];
        String parameter = filter.split(";")[1];
        switch (type) {
            case "Starts with":
                return name -> name.startsWith(parameter);
            case "Ends with":
                return name -> name.endsWith(parameter);
            case "Length":
                return name -> name.length() == Integer.parseInt(parameter);
            case "Contains":
                return name -> name.contains(parameter);
            default:
                throw new IllegalArgumentException("Unknown parameter " + type);
        }
    }

    private static void fillFiltersSet(Set<String> filterSet, String input) {
        String command = input.split(";")[0];
        String type = input.split(";")[1];
        String parameter = input.split(";")[2];
        switch (command) {
            case "Add filter":
                filterSet.add(type + ";" + parameter);
                break;
            case "Remove filter":
                filterSet.remove(type + ";" + parameter);
                break;
        }
    }
}