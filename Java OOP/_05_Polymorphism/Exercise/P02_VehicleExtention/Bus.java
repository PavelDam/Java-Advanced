package _05_Polymorphism.Exercise.P02_VehicleExtention;

public class Bus extends VehicleImpl {

    public static final double WITH_AC = 1.4;

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void setLitersPerKm(double liters) {
        super.setLitersPerKm(liters + WITH_AC);
    }

    public void reduceFuelConsumption() {
        super.setLitersPerKm(litersPerKm - WITH_AC);
    }
    public void setFuelConsumptionWithAc() {
        super.setLitersPerKm(litersPerKm + WITH_AC);

    }

}
