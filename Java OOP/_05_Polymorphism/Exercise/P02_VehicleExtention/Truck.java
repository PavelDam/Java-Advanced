package _05_Polymorphism.Exercise.P02_VehicleExtention;

public class Truck extends VehicleImpl {

    private static final double WITH_AC = 1.6;
    private static final double REFILL_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }


    @Override
    public void setLitersPerKm(double liters) {
        super.setLitersPerKm(liters + WITH_AC);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFILL_PERCENTAGE);
    }
}
