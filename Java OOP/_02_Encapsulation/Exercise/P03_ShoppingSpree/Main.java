package _02_Encapsulation.Exercise.P03_ShoppingSpree;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personMap = new LinkedHashMap<>();
        fillMap(splitInput(scanner), personMap, Person.class);

        if (personMap.isEmpty()) {
            return;
        }

        Map<String, Product> productMap = new LinkedHashMap<>();
        fillMap(splitInput(scanner), productMap, Product.class);

        if (productMap.isEmpty()) {
            return;
        }

        tryToBuyProducts(scanner, personMap, productMap);

        printPersonMap(personMap);

    }

    private static void tryToBuyProducts(Scanner scanner, Map<String, Person> personMap, Map<String, Product> productMap) {
        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String[] commandArr = command.split(" ");
            String personName = commandArr[0];
            String productName = commandArr[1];

            try {
                personMap.get(personName).buyProduct(productMap.get(productName));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }
    }

    private static void printPersonMap(Map<String, Person> personMap) {
        if (!personMap.isEmpty()) {
            for (String person : personMap.keySet()) {
                System.out.println(personMap.get(person));
            }
        }
    }

    private static String[] splitInput(Scanner scanner) {
        return scanner.nextLine().split(";");
    }

    private static <T> void fillMap(String[] inputArr, Map<String, T> resultMap, Class<T> clazz) {
        for (String input : inputArr) {
            String[] currentInput = input.split("=");
            String name = currentInput[0];
            double value = Double.parseDouble(currentInput[1]);

            try {
                T instance = clazz.getDeclaredConstructor(String.class, double.class).newInstance(name, value);
                resultMap.put(name, instance);
            }  catch (Exception e) {
                handleException(e);
            }
        }
    }
    private static void handleException(Exception e) {
        if (e instanceof java.lang.reflect.InvocationTargetException) {
            Throwable cause = e.getCause();
            if (cause instanceof IllegalStateException) {
                System.out.println(cause.getMessage());
                // Handle specific IllegalStateException
            } else {
                // Handle other causes or rethrow
                e.printStackTrace();
            }
        } else {
            // Handle other exceptions
            e.printStackTrace();
        }
    }
}
