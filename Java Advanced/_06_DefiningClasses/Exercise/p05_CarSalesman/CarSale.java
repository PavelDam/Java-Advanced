package _06_DefiningClasses.Exercise.P05_CarSalesman;

import java.util.Map;

public class CarSale {
    private String model;
    private String engine;
    private String weight;
    private String color;

    private Engine engineSpec;

    public CarSale(String model, String engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(Engine engineSpec) {
        this.engineSpec = engineSpec;
    }
@Override
    public String toString(){
        return String
                .format("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s%n"
                        ,model,engine,engineSpec.getPower(),engineSpec.getDisplacement(),engineSpec.getEfficiency(),weight,color);
}
}
