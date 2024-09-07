package _Exams.Exam_20February2021.P03_CarDealership.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> carsList;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.carsList = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > carsList.size()) {
            carsList.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : carsList) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                carsList.remove(car);
                return true;
            }
        }
        return false;
    }

    public int getCount() {
        return carsList.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder(String.format("The cars are in a car _Exams.Exam_20February2021.P03_CarDealership.dealership %s:%n", name));
        for (Car value : carsList) {
            out.append(value)
                    .append(System.lineSeparator());
        }
        return out.toString().trim();
    }

    public Car getLatestCar() {
        if (carsList.isEmpty()) {
            return null;
        } else {
            Car latestCar = carsList.get(0);
            for (Car car : carsList) {
                if (car.getYear() > latestCar.getYear()) {
                    latestCar = car;
                }
            }
            return latestCar;
        }
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : carsList) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }
}
