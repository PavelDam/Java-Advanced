package _06_DefiningClasses.Exercise.P07_Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> personMap = new TreeMap<>();
        while (!input.equals("End")) {
            String[] inputArr = input.split("\\s+");
            String name = inputArr[0];
            String command = inputArr[1];
            String data1 = inputArr[2];
            String data2 = inputArr[3];

            personMap.putIfAbsent(name, new Person());
            Person person = personMap.get(name);

            switch (command) {
                case "company":
                    double data3 = Double.parseDouble(inputArr[4]);
                    Company company = new Company(data1, data2, data3);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(data1, data2);
                    person.addPokemon(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(data1, data2);
                    person.addParent(parent);
                    break;
                case "children":
                    Children children = new Children(data1, data2);
                    person.addChild(children);
                    break;
                case "car":
                    Car car = new Car(data1, data2);
                    person.setCar(car);
                    break;
            }


            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        Person person = personMap.get(name);
        System.out.println(name);
        System.out.println(person.toString());

    }

}
