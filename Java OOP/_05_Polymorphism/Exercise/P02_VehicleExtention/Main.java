package _05_Polymorphism.Exercise.P02_VehicleExtention;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, VehicleImpl> vehicleMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!Character.isDigit(input.charAt(0))) {
            String[] vehicleInputArr = input.split("\\s+");
            String vehicleType = vehicleInputArr[0];
            double fuelQuantity = Double.parseDouble(vehicleInputArr[1]);
            double litersPerKm = Double.parseDouble(vehicleInputArr[2]);
            double tankCapacity = Double.parseDouble(vehicleInputArr[3]);

            getVehicle(vehicleMap, vehicleType, fuelQuantity, litersPerKm, tankCapacity);

            input = scanner.nextLine();
        }
        int commandCount = Integer.parseInt(input);

        while (commandCount > 0) {
            String[] commandArr = scanner.nextLine().split("\\s+");
            String commandType = commandArr[0];
            String vehicleType = commandArr[1];
            double argument = Double.parseDouble(commandArr[2]);

            VehicleImpl vehicle = vehicleMap.get(vehicleType);
            try {
                switch (commandType) {
                    case "Drive":
                        System.out.println(vehicle.drive(argument));
                        break;
                    case "Refuel":
                        vehicle.refuel(argument);
                        break;
                    case "DriveEmpty":
                        if (vehicle instanceof Bus) {
                            ((Bus) vehicle).reduceFuelConsumption();
                            System.out.println(vehicle.drive(argument));
                            ((Bus) vehicle).setFuelConsumptionWithAc();
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            commandCount--;
        }

        vehicleMap.values().forEach(System.out::println);
    }

    private static void getVehicle(Map<String, VehicleImpl> vehicleMap, String vehicleType, double fuelQuantity, double litersPerKm, double tankCapacity) {
        VehicleImpl vehicle = null;

        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelQuantity, litersPerKm, tankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(fuelQuantity, litersPerKm, tankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(fuelQuantity, litersPerKm, tankCapacity);
        }
        vehicleMap.put(vehicleType, vehicle);
    }
}
