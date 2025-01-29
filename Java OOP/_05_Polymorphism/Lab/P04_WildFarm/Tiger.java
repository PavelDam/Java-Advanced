package _05_Polymorphism.Lab.P04_WildFarm;

public class Tiger extends Felime {

    private String livingRegion;

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight,livingRegion);

    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        Integer quantity = food.getQuantity();
        foodEaten += quantity;
    }
}
