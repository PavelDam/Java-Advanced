package _05_Polymorphism.Lab.P03_Animals;

public abstract class Animal {

    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public abstract String explainSelf();

    @Override
    public String toString() {
        return String.format("I am %s and my favourite food is %s", name, favouriteFood);
    }
}
