package _05_Polymorphism.Exercise.P01_Vehicles;

public class Car extends VehicleImpl {

    public static final double WITH_AC = 0.9;

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }

    @Override
    public void setLitersPerKm(double liters) {
        super.setLitersPerKm(liters + WITH_AC);
    }
}
