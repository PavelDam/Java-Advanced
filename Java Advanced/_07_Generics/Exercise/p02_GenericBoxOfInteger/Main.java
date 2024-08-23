package _07_Generics.Exercise.P02_GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            BoxOfInteger<Integer> box = new BoxOfInteger<>(Integer.parseInt(scanner.nextLine()));
            System.out.print(box);
        }
    }
}
