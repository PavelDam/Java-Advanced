package _02_Encapsulation.Lab.P03_ValidationData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            try {
                Person person = new Person(firstName, lastName, age, salary);
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        people.forEach(System.out::println);

    }

}
