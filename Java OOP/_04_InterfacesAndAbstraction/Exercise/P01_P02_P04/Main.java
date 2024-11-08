package _04_InterfacesAndAbstraction.Exercise.P01_P02_P04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyers = new LinkedHashMap<>();

        addBuyerInBuyers(scanner, count, buyers);

        buyFood(scanner, buyers);

        printFood(buyers);

    }

    private static void printFood(Map<String, Buyer> buyers) {
        System.out.println(buyers.values().stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }

    private static void buyFood(Scanner scanner, Map<String, Buyer> buyers) {
        String buyerName = scanner.nextLine();

        while (!buyerName.equals("End")) {
            if (buyers.containsKey(buyerName)) {
                buyers.get(buyerName).buyFood();
            }
            buyerName = scanner.nextLine();
        }
    }

    private static void addBuyerInBuyers(Scanner scanner, int count, Map<String, Buyer> buyers) {
        while (count > 0) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);

            Buyer buyer;

            if (inputArr.length == 3) {
                String group = inputArr[2];
                buyer = new Rebel(name, age, group);
            } else {
                String id = inputArr[2];
                String birthDate = inputArr[3];
                buyer = new Citizen(name, age, id, birthDate);
            }
            buyers.put(name, buyer);

            count--;
        }
    }
}