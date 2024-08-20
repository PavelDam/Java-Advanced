package _06_DefiningClasses.Exercise.P02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> map = new HashMap<>();

        while (counter-- > 0) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String name = inputArr[0];
            double salary = Double.parseDouble(inputArr[1]);
            String position = inputArr[2];
            String department = inputArr[3];

            Employee employee = new Employee(name, salary, position, department);
            if (!map.containsKey(department)) {
                map.put(department, new ArrayList<>());
            }

            if (inputArr.length == 5) {
                if (inputArr[4].contains("@")) {
                    employee.setEmail(inputArr[4]);
                } else {
                    employee.setAge(Integer.parseInt(inputArr[4]));
                }
            } else if (inputArr.length == 6) {
                employee.setEmail(inputArr[4]);
                employee.setAge(Integer.parseInt(inputArr[5]));
            }

            map.get(department).add(employee);
        }
        String department = "";
        double averageSalary = 0;

        for (String dep : map.keySet()) {
            double current = map.get(dep).stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            if (current > averageSalary) {
                averageSalary = current;
                department = dep;
            }
        }

        System.out.println("Highest Average Salary: " + department);
        map.get(department).stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(v -> System.out.printf("%s %.2f %s %d%n", v.getName(), v.getSalary(), v.getEmail(), v.getAge()));
    }
}
