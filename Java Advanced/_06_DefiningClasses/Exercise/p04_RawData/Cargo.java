package _06_DefiningClasses.Exercise.P04_RawData;

public class Cargo {
    private int cargoWeight;
    private String type;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.type = cargoType;
    }

    public String getType() {
        return type;
    }
}
