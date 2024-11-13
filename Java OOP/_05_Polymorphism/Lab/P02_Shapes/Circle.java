package _05_Polymorphism.Lab.P02_Shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        if (perimeter == null) {
            perimeter = 2 * Math.PI * radius;
        }
        return perimeter;
    }

    @Override
    public Double calculateArea() {
        if (area == null) {
            area = Math.PI * radius * radius;
        }
        return area;
    }
}
