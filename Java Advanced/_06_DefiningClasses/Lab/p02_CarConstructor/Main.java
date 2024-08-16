package _06_DefiningClasses.Lab.P02_CarConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();
        while (carCount-- > 0) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String brand = inputArr[0];

            Car car = inputArr.length == 1
                    ? new Car(brand)
                    : new Car(brand, inputArr[1], Integer.parseInt(inputArr[2]));

            carsList.add(car);
        }
        carsList.forEach(System.out::println);
    }
}
