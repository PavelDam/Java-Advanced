package _06_DefiningClasses.Lab.P01_CarInfo;

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
            String model = inputArr[1];
            int horsePower = Integer.parseInt(inputArr[2]);

            Car car = new Car();

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            carsList.add(car);
        }

        carsList.forEach(Car-> System.out.println(Car.toString()));
    }
}
