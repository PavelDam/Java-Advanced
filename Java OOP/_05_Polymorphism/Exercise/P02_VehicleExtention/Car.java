package _05_Polymorphism.Exercise.P02_VehicleExtention;

public class Car extends VehicleImpl {

    public static final double WITH_AC = 0.9;

    public Car(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }



    @Override
    public void setLitersPerKm(double liters) {
        super.setLitersPerKm(liters + WITH_AC);
    }
}
