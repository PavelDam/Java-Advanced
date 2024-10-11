package _02_Encapsulation.Exercise.P03_ShoppingSpree;

public class Product {
  private String name;
  private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw  new IllegalStateException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw  new IllegalStateException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
