package _Exams.Exam_23October2021;

import java.util.*;

public class P01_AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(queueIngredients::offer);

        ArrayDeque<Integer> stackFreshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(stackFreshness::push);

        Map<String, Integer> cocktailsMap = Map.of(
                "Pear Sour", 0,
                "The Harvest", 0,
                "Apple Hinny", 0,
                "High Fashion", 0);


        while (!queueIngredients.isEmpty() && !stackFreshness.isEmpty()) {

            int ingredient = queueIngredients.poll();
            if (ingredient == 0) {
                continue;
            }

            int freshness = stackFreshness.pop();
            int totalFreshness = ingredient * freshness;
            String cocktail = "";

            switch (totalFreshness) {
                case 150:
                    cocktail = "Pear Sour";
                    cocktailsMap.put(cocktail, cocktailsMap.get(cocktail) + 1);
                    break;
                case 250:
                    cocktail = "The Harvest";
                    cocktailsMap.put(cocktail, cocktailsMap.get(cocktail) + 1);
                    break;
                case 300:
                    cocktail = "Apple Hinny";
                    cocktailsMap.put(cocktail, cocktailsMap.get(cocktail) + 1);
                    break;
                case 400:
                    cocktail = "High Fashion";
                    cocktailsMap.put(cocktail, cocktailsMap.get(cocktail) + 1);
                    break;
                default:
                    ingredient += 5;
                    queueIngredients.offer(ingredient);
                    break;
            }
        }
        boolean allCocktails = true;

        Map<String, Integer> doneCocktails = new TreeMap<>();
        for (String s : cocktailsMap.keySet()) {
            if (cocktailsMap.get(s) > 0) {
                doneCocktails.put(s, cocktailsMap.get(s));
            } else {
                allCocktails = false;
            }
        }

        int sum = 0;
        if (!queueIngredients.isEmpty()) {
            for (Integer queueIngredient : queueIngredients) {
                sum += queueIngredient;
            }
        }
        System.out.print(allCocktails
                ? String.format("It's party time! The cocktails are ready!%n")
                : String.format("What a pity! You didn't manage to prepare all cocktails.%n"));
        if (sum > 0) {
            System.out.printf("Ingredients left: %d%n", sum);
        }
        doneCocktails.keySet().forEach(k -> System.out.printf(" # %s --> %d%n", k, doneCocktails.get(k)));

    }
}
