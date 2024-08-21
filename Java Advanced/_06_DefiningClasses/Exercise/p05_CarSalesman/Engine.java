package _06_DefiningClasses.Exercise.P05_CarSalesman;

import java.lang.invoke.StringConcatException;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;


    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

}
