package _07_Generics.Exercise.P05_GenericCountMethodString;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countElements = Integer.parseInt(scanner.nextLine());
        CountString<String> list = new CountString<>();

        IntStream.range(0, countElements)
                .mapToObj(i -> scanner.nextLine())
                .forEach(list::addElement);

        long count = list.count(scanner.nextLine());

        System.out.println(count);
    }
}
