package _06_DefiningClasses.Exercise.P07_Google;

public class Car {
    private final String carModel;
    private final String carSpeed;

    public Car(String carModel, String carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }
    @Override
    public String toString() {
        return carModel + " " + carSpeed;
    }
}
