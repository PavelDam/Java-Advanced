package _02_Encapsulation.Exercise.P04_PizzaCalories;

import java.util.List;
import java.util.Set;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        Set<String> flourTypeSet = Set.of("White", "Wholegrain");

        if (!flourTypeSet.contains(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {

        Set<String> bakingTechniqueSet = Set.of("Crispy", "Chewy", "Homemade");

        if (!bakingTechniqueSet.contains(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {

        if (weight < 1 || weight > 200) {
            throw  new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
            this.weight = weight;
    }

    public double calculateCalories() {

        double flourModifier = 0;

        switch (flourType) {
            case "White":
                flourModifier = 1.5;
                break;
            case "Wholegrain":
                flourModifier = 1.0;
                break;
        }

        double bakingTechniqueModifier = 0;

        switch (bakingTechnique) {
            case "Crispy":
                bakingTechniqueModifier = 0.9;
                break;
            case "Chewy":
                bakingTechniqueModifier = 1.1;
                break;
            case "Homemade":
                bakingTechniqueModifier = 1.0;
                break;
        }
        return (2 * weight) * flourModifier * bakingTechniqueModifier;
    }
}
