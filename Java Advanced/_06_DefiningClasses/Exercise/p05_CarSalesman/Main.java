package _06_DefiningClasses.Exercise.P05_CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engineMap = getEngineMap(scanner);

        List<CarSale> cars = getCarSales(scanner, engineMap);

        cars.forEach(System.out::print);

    }

    private static List<CarSale> getCarSales(Scanner scanner, Map<String, Engine> engineMap) {
        int carsCounter = Integer.parseInt(scanner.nextLine());
        List<CarSale> cars = new ArrayList<>();
        while (carsCounter-- > 0) {
            String[] carArr = scanner.nextLine().split("\\s+");
            String model = carArr[0];
            String engine = carArr[1];

            CarSale car = new CarSale(model, engine);
            if (carArr.length == 3) {
                String data = carArr[2];

                if (Character.isLetter(carArr[2].charAt(0))) {
                    car.setColor(data);
                } else {
                    car.setWeight(data);
                }
            } else if (carArr.length == 4) {
                String weight = carArr[2];
                String color = carArr[3];
                car.setWeight(weight);
                car.setColor(color);
            }
            Engine current= engineMap.get(engine);
            car.setEngine(current);
            cars.add(car);
        }
        return cars;
    }

    private static Map<String, Engine> getEngineMap(Scanner scanner) {
        int enginesCount = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engineMap = new LinkedHashMap<>();

        while (enginesCount-- > 0) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String model = inputArr[0];
            String power = inputArr[1];

            Engine engine = new Engine(model, power);

            if (inputArr.length == 3) {
                String data = inputArr[2];

                if (Character.isLetter(inputArr[2].charAt(0))) {
                    engine.setEfficiency(data);
                } else {
                    engine.setDisplacement(data);
                }
            } else if (inputArr.length == 4) {
                String displacement = inputArr[2];
                String efficiency = inputArr[3];
                engine.setDisplacement(displacement);
                engine.setEfficiency(efficiency);
            }

            engineMap.put(model, engine);

        }
        return engineMap;
    }
}
