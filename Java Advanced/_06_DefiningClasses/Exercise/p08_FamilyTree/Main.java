package _06_DefiningClasses.Exercise.P08_FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String personInfo = scanner.nextLine();
        Map<String, Person> peopleByName = new LinkedHashMap<>();
        Map<String, Person> peopleByDate = new LinkedHashMap<>();

        List<String> relations = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("End")) {
                break;
            }
            if (line.contains(" - ")) {
                relations.add(line);
            } else {
                String[] parts = line.split(" ");
                String name = parts[0] + " " + parts[1];
                String date = parts[2];
                Person person = peopleByName.getOrDefault(name, new Person(name));
                person.setBirthdate(date);
                peopleByName.put(name, person);
                peopleByDate.put(date, person);
            }
        }

        for (String relation : relations) {
            String[] parts = relation.split(" - ");
            Person parent = getPerson(parts[0], peopleByName, peopleByDate);
            Person child = getPerson(parts[1], peopleByName, peopleByDate);
            parent.addChild(child);
            child.addParent(parent);
        }

        Person person = peopleByName.getOrDefault(personInfo, peopleByDate.get(personInfo));
        System.out.println(person);
    }

    private static Person getPerson(String info, Map<String, Person> peopleByName, Map<String, Person> peopleByDate) {
        if (info.contains("/")) {
            return peopleByDate.get(info);
        } else {
            return peopleByName.get(info);
        }
    }
}

