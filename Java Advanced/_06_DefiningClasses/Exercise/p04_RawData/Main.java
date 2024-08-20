package _06_DefiningClasses.Exercise.P04_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCounter = Integer.parseInt(scanner.nextLine());
        List<CarInfo> cars = new ArrayList<>();

        while (carsCounter-- > 0) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String model = inputArr[0];
            int engineSpeed = Integer.parseInt(inputArr[1]);
            int enginePower = Integer.parseInt(inputArr[2]);
            int cargoWeight = Integer.parseInt(inputArr[3]);
            String cargoType = inputArr[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tires = new ArrayList<>();

            for (int i = 5; i < 13; i += 2) {
                double tirePressure = Double.parseDouble(inputArr[i]);

                Tire tire = new Tire(tirePressure);
                tires.add(tire);
            }
            CarInfo car = new CarInfo(model, engine, cargo, tires);
            cars.add(car);
        }
        System.out.println();
        String command = scanner.nextLine();
        getVehicle(command, cars);
        //flamable print all cars whose Cargo Type is "flamable" and have Engine Power > 250


    }

    public static void getVehicle(String command, List<CarInfo> cars) {
        Predicate<CarInfo> commandPredicate = cargo -> cargo.getCargoType().getType().equals(command);
        Predicate<CarInfo> tiresPredicate = car -> car.getTires().stream().anyMatch(tire -> tire.getTirePressure() < 1);
        Predicate<CarInfo> enginePower = car -> car.getEngine().getEnginePower() > 250;

        cars.stream()
                .filter(command.equals("fragile") ? commandPredicate.and(tiresPredicate) :
                        command.equals("flamable") ? commandPredicate.and(enginePower) : null)
                .forEach(car -> System.out.println(car.getModel()));

//        if (command.equals("fragile")) {
//
//            cars.stream().filter(commandPredicate)
//                    .filter(tiresPredicate).forEach(car -> System.out.println(car.getModel()));
//
//        } else if (command.equals("flamable")) {
//            //flamable print all cars whose Cargo Type is "flamable" and have Engine Power > 250
//            cars.stream().filter(commandPredicate)
//                    .filter(enginePower)
//                    .forEach(car -> System.out.println(car.getModel()));
//        }
    }


}

