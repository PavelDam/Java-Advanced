package _01_StacksAndQueues.Exercises.Queues;

import java.util.*;
import java.util.stream.Collectors;

public class P09_PoisonousPlants {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int plantsCount = Integer.parseInt(scanner.nextLine());

        List<Integer> plantsList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        boolean plantDie = true;
        int days = 0;
        int size = plantsCount;

        while (plantDie) {
            plantDie = false;
            for (int i = size - 1; i > 0; i--) {
                int rightPlant = plantsList.get(i);
                int leftPlant = plantsList.get(i - 1);
                if (rightPlant > leftPlant) {
                    plantsList.remove(i);
                    plantDie = true;
                }
            }
            size = plantsList.size();
            if (plantDie) {
                days++;
            }

        }
        System.out.println(days);
    }
}
