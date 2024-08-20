package _06_DefiningClasses.Exercise.P03_SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carCount = Integer.parseInt(scanner.nextLine());
        Map<String, CarInfo> cars = new LinkedHashMap<>();
        while (carCount-- > 0) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String model = inputArr[0];
            double fuelAmount = Double.parseDouble(inputArr[1]);
            double fuelCostPerKm = Double.parseDouble(inputArr[2]);

            CarInfo car = new CarInfo(model, fuelAmount, fuelCostPerKm);

            cars.put(model, car);
        }
        String commandInput = scanner.nextLine();

        while (!commandInput.equals("End")) {
            String[] commandArr = commandInput.split("\\s+");
            CarInfo carToDrive = cars.get(commandArr[1]);
            int distance = Integer.parseInt(commandArr[2]);

            carToDrive.drive(distance);

            commandInput = scanner.nextLine();
        }
        cars.keySet().forEach(k -> System.out.println(cars.get(k)));
    }
}
