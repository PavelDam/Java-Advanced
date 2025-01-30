package _05_Polymorphism.Exercise.P02_VehicleExtention;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    protected double fuelQuantity;
    protected double litersPerKm;

    protected double tankCapacity;

    public VehicleImpl(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setLitersPerKm(litersPerKm);
        this.tankCapacity = tankCapacity;
    }

    public void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    @Override
    public String driveWithoutAc(double distance) {
        return "asd";
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
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (liters + fuelQuantity > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), fuelQuantity);
    }
}
