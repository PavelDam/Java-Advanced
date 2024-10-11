package _02_Encapsulation.Exercise.P01_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setLength(double length) {
        validateInputNumbers(length, "Length");
        this.length = length;
    }

    public void setWidth(double width) {
        validateInputNumbers(width, "Width");
        this.width = width;
    }

    public void setHeight(double height) {
        validateInputNumbers(height, "Height");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * width * height + 2 * length * height;
    }

    public double calculateVolume() {
        return length * width * height;
    }

    private void validateInputNumbers(double number, String type) {
        if (number < 1) {
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", type));
        }
    }
}
