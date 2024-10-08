
package _01_WorkingWithAbstraction.Exercise.P06_GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] inputItems = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);


        for (int i = 0; i < inputItems.length; i += 2) {
            String currentItem = inputItems[i];
            long amount = Long.parseLong(inputItems[i + 1]);

            bag.add( amount, currentItem);
        }
        bag.print();
    }




}