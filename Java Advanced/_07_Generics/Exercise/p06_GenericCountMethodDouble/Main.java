package _07_Generics.Exercise.P06_GenericCountMethodDouble;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countElements = Integer.parseInt(scanner.nextLine());
        CountDouble<Double> list = new CountDouble<>();
        IntStream.range(0, countElements)
                .mapToDouble(i -> Double.parseDouble(scanner.nextLine()))
                .forEach(list::addElement);

        long count = list.count(Double.parseDouble(scanner.nextLine()));
        System.out.println(count);
    }
}
