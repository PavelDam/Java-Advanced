package _04_InterfacesAndAbstraction.Lab.P05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] inputArr = getSplitInput(input);
            String name = inputArr[0];

            Identifiable identifiable;
            if (inputArr.length == 3) {
                int age = Integer.parseInt(inputArr[1]);
                String id = inputArr[2];
                identifiable = new Citizen(name, age, id);

            } else {
                String id = inputArr[1];
                identifiable = new Robot(id, name);
            }

            identifiables.add(identifiable);

            input = scanner.nextLine();
        }
        String searchId = scanner.nextLine();

        identifiables.stream().map(Identifiable::getId)
                .filter(id-> id.endsWith(searchId))
                .forEach(System.out::println);
    }

    private static String[] getSplitInput(String input) {
        return input.split("\\s+");
    }
}
