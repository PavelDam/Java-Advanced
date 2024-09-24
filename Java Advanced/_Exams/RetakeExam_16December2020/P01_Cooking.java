package _Exams.RetakeExam_16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Cooking {
    private static final int BREED = 25;
    private static final int CAKE = 50;
    private static final int PASTRY = 75;
    private static final int FRUIT_PIE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(liquidsQueue::offer);

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredientsStack::push);

        Map<String, Integer> foodMap = new TreeMap<>();
        foodMap.put("Bread", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pastry", 0);
        foodMap.put("Fruit Pie", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquid + ingredient;

            String food = "";
            if (sum == BREED) {
                food = "Bread";
            } else if (sum == CAKE) {
                food = "Cake";
            } else if (sum == PASTRY) {
                food = "Pastry";
            } else if (sum == FRUIT_PIE) {
                food = "Fruit Pie";
            } else {
                ingredient += 3;
                ingredientsStack.push(ingredient);
                continue;
            }
            foodMap.put(food, foodMap.get(food) + 1);
        }
        boolean allFoods = checkFood(foodMap);
        System.out.println(allFoods
                ? "Wohoo! You succeeded in cooking all the food!"
                : "Ugh, what a pity! You didn't have enough materials to cook everything.");
        printIngredients(liquidsQueue, 1);
        printIngredients(ingredientsStack, 2);
        printFoodMap(foodMap);
    }

    private static void printFoodMap(Map<String, Integer> foodMap) {
        foodMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static void printIngredients(ArrayDeque<Integer> ingredients, int count) {

        String type = count == 1
                ? "Liquids"
                : "Ingredients";
        if (ingredients.isEmpty()) {
            System.out.printf("%s left: none%n", type);
        } else {
            System.out.print(type + " left: ");
            System.out.println(ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }

    private static boolean checkFood(Map<String, Integer> foodMap) {
        return foodMap.keySet().stream().allMatch(k -> foodMap.get(k) > 0);
    }
}
