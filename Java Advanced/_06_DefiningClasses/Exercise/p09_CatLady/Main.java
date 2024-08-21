package _06_DefiningClasses.Exercise.P09_CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Cat> catMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputArr = input.split("\\s+");
            String breed = inputArr[0];
            String name = inputArr[1];
            double number = Double.parseDouble(inputArr[2]);
            catMap.put(name, new Cat(name, breed, number));

            input = scanner.nextLine();
        }
        String searchingName = scanner.nextLine();
        System.out.println(catMap.get(searchingName).toString());

    }
}
