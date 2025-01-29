package _05_Polymorphism.Lab.P04_WildFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] animalInfoArr = input.split("\\s+");
            String animalType = animalInfoArr[0];
            String animalName = animalInfoArr[1];
            Double animalWeight = Double.parseDouble(animalInfoArr[2]);
            String animalLivingRegion = animalInfoArr[3];

            Animal animal = null;

            switch (animalType) {
                case "Cat":
                    String catBreed = animalInfoArr[4];
                    animal = new Cat(animalType, animalName, animalWeight, animalLivingRegion, catBreed);

                    break;
                case "Tiger":
                    animal = new Tiger(animalType, animalName,animalWeight, animalLivingRegion);
                    break;
                case "Mouse":
                    animal = new Mouse(animalType, animalName,animalWeight, animalLivingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalType, animalName,animalWeight, animalLivingRegion);
                    break;
            }
            String[] foodArr = scanner.nextLine().split("\\s+");
            String foodType = foodArr[0];
            Integer foodQuantity = Integer.parseInt(foodArr[1]);
            Food food = null;

            switch (foodType) {
                case "Vegetable":
                    food = new Vegetable(foodQuantity);
                    break;

                case "Meat":
                    food = new Meat(foodQuantity);
                    break;
            }
            animal.makeSound();

            try {
                animal.eat(food);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(animal);

            input = scanner.nextLine();
        }
    }
}
