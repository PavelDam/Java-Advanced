package _03_SetsAndMaps.Lab._02_Maps;

import com.sun.security.jgss.GSSUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> map = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] inputArr = input.split(", ");
            String shop = inputArr[0];
            String product = inputArr[1];
            double price = Double.parseDouble(inputArr[2]);

            if (!map.containsKey(shop)) {
                map.put(shop, new LinkedHashMap<>());
            }
            map.get(shop).put(product, price);

            input = scanner.nextLine();
        }
        for (String shop : map.keySet()) {
            System.out.println(shop + "->");
            Map<String, Double> currentShop = map.get(shop);
            for (String product: currentShop.keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",product,currentShop.get(product));
            }
        }

    }
}
