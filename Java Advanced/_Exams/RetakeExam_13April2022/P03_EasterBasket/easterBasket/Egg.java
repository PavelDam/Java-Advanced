package _Exams.RetakeExam_13April2022.P03_EasterBasket.easterBasket;

public class Egg {
    private String color;
    private int strength;
    private String shape;

    public Egg(String color, int strength, String shape) {
        this.color = color;
        this.strength = strength;
        this.shape = shape;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public int getStrength() {
        return strength;
    }

    public String getShape() {
        return shape;
    }

    @Override
    public String toString() {
        return String.format("%s egg, with %d strength and %s shape.", color, strength, shape);
    }
}
