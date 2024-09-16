package _Exams.Exam_28June2020.P03_Parking.parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        return data.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s%n", type));
        data.forEach(car -> sb.append(car).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
