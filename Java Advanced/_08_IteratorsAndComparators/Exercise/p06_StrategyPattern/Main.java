package _08_IteratorsAndComparators.Exercise.p06_StrategyPattern;


import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        TreeSet<Person> firstSet = new TreeSet<>(new FirstComparator());
        TreeSet<Person> secondSet = new TreeSet<>(new SecondComparator());

        for (int i = 0; i < count; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);
            Person person = new Person(name, age);
            firstSet.add(person);
            secondSet.add(person);
        }
//        Set<Person> personSet = IntStream.range(0, count)
//                .mapToObj(i -> scanner.nextLine().split("\\s+"))
//                .map(arr -> new Person(arr[0], Integer.parseInt(arr[1])))
//                .collect(Collectors.toSet());

        firstSet.forEach(p -> System.out.println(p.getName() + " " + p.getAge()));

        secondSet.forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
    }
}
