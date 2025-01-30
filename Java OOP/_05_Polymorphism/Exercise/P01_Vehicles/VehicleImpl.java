package _05_Polymorphism.Exercise.P01_Vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    protected double fuelQuantity;
    protected double litersPerKm;

    public VehicleImpl(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.setLitersPerKm(litersPerKm);
    }

    public void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * this.getLitersPerKm();
        if (fuelNeeded > this.fuelQuantity) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.fuelQuantity -= fuelNeeded;

        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), fuelQuantity);
    }
}
