package _05_Polymorphism.Lab.P04_WildFarm;

public abstract class Food {

    protected Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
