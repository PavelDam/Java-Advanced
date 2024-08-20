package _06_DefiningClasses.Exercise.P01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Function<Scanner, Person> applyPerson = s -> {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            return new Person(name, age);

        };

        List<Person> personList = IntStream.rangeClosed(1, count).mapToObj(p -> applyPerson.apply(scanner))
                .filter(person -> person.getAge() > 30)
                .collect(Collectors.toList());

        personList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
