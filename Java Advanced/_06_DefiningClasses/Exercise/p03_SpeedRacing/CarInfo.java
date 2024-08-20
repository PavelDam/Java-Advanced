package _06_DefiningClasses.Exercise.P03_SpeedRacing;

public class CarInfo {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTraveled;


    public CarInfo(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public double neededFuel(int distance) {
        return this.fuelCostPerKm * distance;
    }

    public boolean checkFuel(int distance) {
        return neededFuel(distance) <= this.fuelAmount;
    }

    public void drive(int distance) {
        if (checkFuel(distance)) {
            this.fuelAmount -= neededFuel(distance);
            this.distanceTraveled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTraveled);
    }
}
