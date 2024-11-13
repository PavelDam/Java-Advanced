package _05_Polymorphism.Lab.P02_Shapes;

public abstract class Shape {
    protected Double perimeter;
    protected Double area;

    public abstract Double calculatePerimeter();
    public abstract Double calculateArea();
}
