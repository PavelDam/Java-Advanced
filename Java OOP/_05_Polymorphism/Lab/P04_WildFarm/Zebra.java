package _05_Polymorphism.Lab.P04_WildFarm;

public class Zebra extends Mammal{
    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException("Zebra are not eating that type of food!");
        }
        Integer quantity = food.getQuantity();
        foodEaten += quantity;
    }
}
