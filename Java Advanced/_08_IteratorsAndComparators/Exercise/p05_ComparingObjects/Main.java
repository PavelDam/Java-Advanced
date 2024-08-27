package _08_IteratorsAndComparators.Exercise.p05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> personList = new ArrayList<>();

        while (!input.equals("END")) {
            addPerson(input, personList);
            input = scanner.nextLine();
        }

        Person person = personList.get(Integer.parseInt(scanner.nextLine()) - 1);

        int matches = 0;
        for (Person personFromList : personList) {
            if (personFromList.compareTo(person) == 0) {
                matches++;
            }
        }
        if (matches == 1) {
            System.out.println("No matches");
        } else {
            System.out.print(matches + " " + (personList.size() - matches) + " " + personList.size());
        }

    }

    private static void addPerson(String input, List<Person> personList) {
        String[] inputArr = input.split("\\s+");

        String name = inputArr[0];
        int age = Integer.parseInt(inputArr[1]);
        String town = inputArr[2];

        Person person = new Person(name, age, town);
        personList.add(person);
    }
}
