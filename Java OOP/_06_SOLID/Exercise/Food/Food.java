package _06_SOLID.Exercise.Food;

import _06_SOLID.Exercise.Product;

import java.util.List;

public abstract class Food implements Product {

    private double grams;
    private double caloriesPer100Grams;

    public Food(double grams, double caloriesPer100Grams) {
        this.grams = grams;
        this.caloriesPer100Grams = caloriesPer100Grams;
    }

    @Override
    public double getCalories() {
        return (caloriesPer100Grams / 100) * grams;
    }

    @Override
    public double getKilograms() {
        return grams / 1000;
    }
}
