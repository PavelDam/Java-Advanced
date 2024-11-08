package _04_InterfacesAndAbstraction.Exercise.P03_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> birthables = new ArrayList<>();

        while (!input.equals("End")) {

            String[] inputArr = getSplitInput(input);
            String type = inputArr[0];
            String name = inputArr[1];

            addPetAndCitizenToBirthables(birthables, inputArr, type, name);

            input = scanner.nextLine();
        }
        String searchingYear = scanner.nextLine();

        printMatchingYear(birthables, searchingYear);
    }

    private static void printMatchingYear(List<Birthable> birthables, String searchingYear) {
        birthables.stream().map(Birthable::getBirthDate).filter(date -> date.endsWith(searchingYear))
                .forEach(System.out::println);
    }

    private static void addPetAndCitizenToBirthables(List<Birthable> birthables, String[] inputArr, String type, String name) {
        Birthable birthable = null;

        if (type.equals("Citizen")) {
            int age = Integer.parseInt(inputArr[2]);
            String id = inputArr[3];
            String birthDate = inputArr[4];

            birthable = new Citizen(name, age, id, birthDate);

        } else if (type.equals("Pet")) {
            String birthDate = inputArr[2];
            birthable = new Pet(name, birthDate);
        }

        if (birthable != null) {
            birthables.add(birthable);
        }
    }

    private static String[] getSplitInput(String input) {
        return input.split("\\s+");
    }
}
