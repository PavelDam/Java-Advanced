package _01_WorkingWithAbstraction.Lab.P04_HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        DiscountType discountType = DiscountType.fromString(input[3]);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, days, season, discountType);

        System.out.printf("%.2f",priceCalculator.calculatePrice());
    }
}
