package _05_FunctionalProgramming.Lab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p05_FilterByAge {
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int personCount = Integer.parseInt(scanner.nextLine());

        Function<Scanner, Person> readPerson = sc -> {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            return new Person(name, age);
        };
        List<Person> personList = IntStream.range(0, personCount)
                .mapToObj(p -> readPerson.apply(scanner))
                .collect(Collectors.toList());

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> ageFilter = getFilter(condition, age);
        Consumer<Person> printer = print(format);

        personList.stream().filter(ageFilter).forEach(printer);
    }

    private static Consumer<Person> print(String format) {
        switch (format) {

            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Unknown format: " + format);

        }
    }

    private static Predicate<Person> getFilter(String condition, int age) {
        switch (condition) {
            case "younger":
                return p -> p.age <= age;
            case "older":
                return p -> p.age >= age;

            default:
                throw new IllegalArgumentException("Unknown condition " + condition);
        }

    }
}





