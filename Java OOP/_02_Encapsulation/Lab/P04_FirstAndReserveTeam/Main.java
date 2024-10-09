package _02_Encapsulation.Lab.P04_FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String firstName = inputArr[0];
            String lastName = inputArr[1];
            int age = Integer.parseInt(inputArr[2]);
            double salary = Double.parseDouble(inputArr[3]);

            Person person = new Person(firstName, lastName, age, salary);
            personList.add(person);
        }
        Team team = new Team("Black Eagles");
        personList.forEach(team::addPlayer);

        System.out.println("First team have "+team.getFirstTeam().size()+" players");
        System.out.println("Reserved team have "+team.getReserveTeam().size()+" players");
    }
}
