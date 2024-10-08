package _08_IteratorsAndComparators.Exercise.p03_StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StackIterator stackIterator = new StackIterator();

        String line = scanner.nextLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            if ("Pop".equals(command)) {
                try {
                    stackIterator.pop();
                } catch (IllegalStateException ex) {
                    System.out.println(ex.getMessage());
                }
            }else if ("Push".equals(command)){
                Arrays.stream(line.split("[\\s,]+"))
                        .skip(1)
                        .map(Integer::parseInt)
                        .forEach(stackIterator::push);
            }

            line = scanner.nextLine();
        }
        stackIterator.forEach(System.out::println);
        stackIterator.forEach(System.out::println);
    }

}
