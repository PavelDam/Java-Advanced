package _02_Encapsulation.Exercise.P04_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String[] pizzaInputArr = inputSplit(scanner);
            String name = pizzaInputArr[1];
            int numberOfToppings = Integer.parseInt(pizzaInputArr[2]);

            Pizza pizza = new Pizza(name, numberOfToppings);

            String[] doughInputArr = inputSplit(scanner);
            String flourType = doughInputArr[1];
            String bakingTechnique = doughInputArr[2];
            double doughWeight = Double.parseDouble(doughInputArr[3]);

            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);

            String input = scanner.nextLine();

            while (!"END".equals(input)) {
                String[] toppingArr = inputSplit(input);
                String toppingType = toppingArr[1];
                double toppingWeight = Double.parseDouble(toppingArr[2]);

                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);
                input = scanner.nextLine();
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static String[] inputSplit(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static String[] inputSplit(String input) {
        return input.split("\\s+");
    }
}
