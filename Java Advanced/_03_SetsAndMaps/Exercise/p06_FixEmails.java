package _03_SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String, String> map = new LinkedHashMap<>();
        while (!name.equals("stop")) {
            String mail = scanner.nextLine();
            if (!mail.endsWith("us") && !mail.endsWith("uk") && !mail.endsWith("com")) {
                map.put(name, mail);
            }


            name = scanner.nextLine();
        }
        map.forEach((entry, value) -> System.out.printf("%s -> %s%n", entry, value));
    }
}
