package _03_SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebookMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("search")) {

            String[] inputArr = input.split("-");
            String name = inputArr[0];
            String number = inputArr[1];

            phonebookMap.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {

            if (phonebookMap.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebookMap.get(input));
            }else{
                System.out.printf("Contact %s does not exist.%n",input);
            }
            input = scanner.nextLine();
        }
    }
}