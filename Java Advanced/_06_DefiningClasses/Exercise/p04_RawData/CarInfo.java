package _06_DefiningClasses.Exercise.P04_RawData;

import java.util.List;

public class CarInfo {
    private String model;
    private Engine engine;
    private List<Tire> tires;
    private Cargo cargoType;

    public CarInfo(String model, Engine engine, Cargo cargoType, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargoType = cargoType;
        this.tires = tires;
    }

    public Cargo getCargoType() {
        return this.cargoType;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Tire> getTires() {
        return tires;
    }


}

