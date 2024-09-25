package _Exams.RetakeExam_18August2021;

import java.util.*;
import java.util.stream.Collectors;

public class P01_PastryShop {
    private static final String BISCUIT = "Biscuit";
    private static final int BISCUIT_VALUE_NEEDED = 25;
    private static final String CAKE = "Cake";
    private static final int CAKE_VALUE_NEEDED = 50;
    private static final String PASTRY = "Pastry";
    private static final int PASTRY_VALUE_NEEDED = 75;
    private static final String PIE = "Pie";
    private static final int PIE_VALUE_NEEDED = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(liquidsQueue::offer);
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredientsStack::push);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put(BISCUIT, 0);
        map.put(CAKE, 0);
        map.put(PIE, 0);
        map.put(PASTRY, 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquid + ingredient;

            String food = "";
            if (sum == BISCUIT_VALUE_NEEDED) {
                food = BISCUIT;
            } else if (sum == CAKE_VALUE_NEEDED) {
                food = CAKE;
            } else if (sum == PASTRY_VALUE_NEEDED) {
                food = PASTRY;
            } else if (sum == PIE_VALUE_NEEDED) {
                food = PIE;
            } else {
                ingredient += 3;
                ingredientsStack.push(ingredient);
                continue;
            }
            map.put(food, map.get(food) + 1);
        }
        boolean allFood = map.entrySet().stream().allMatch(entry -> entry.getValue() > 0);

        System.out.println(allFood
                ? "Great! You succeeded in cooking all the food!"
                : "What a pity! You didn't have enough materials to cook everything.");
        printComponents(liquidsQueue, "Liquids");
        printComponents(ingredientsStack, "Ingredients");

        printMaterials(map);
    }

    private static void printMaterials(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> sb.append(key).append(": ").append(value).append(System.lineSeparator()));
        System.out.println(sb.toString().trim());
    }

    private static void printComponents(ArrayDeque<Integer> deque, String type) {
        System.out.print(type + " left: ");
        if (deque.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(deque.stream().map(String::valueOf).collect(Collectors.joining(", "))
            );
        }
    }
}
