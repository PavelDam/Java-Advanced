package _03_Inheritance.Exercise.P04_NeedForSpeed;

public class RaceMotorcycle extends Motorcycle{
    final static double DEFAULT_FUEL_CONSUMPTION = 8;
    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }


}
