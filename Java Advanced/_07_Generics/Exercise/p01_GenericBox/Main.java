package _07_Generics.Exercise.P01_GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            Box<String> box = new Box<>(scanner.nextLine());
            System.out.print(box);
        }
    }
}
