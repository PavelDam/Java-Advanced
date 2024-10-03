package _01_WorkingWithAbstraction.Lab.P03_StudentSystem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentSystem {
    private  Map<String, Student> students;

    public StudentSystem() {
        this.students = new LinkedHashMap<>();
    }

    public void parseCommand(String input) {
        String[] tokens = input.split("\\s+");
        String command = tokens[0];
        String name = tokens[1];

        switch (command) {
            case "Create":
                int age = Integer.parseInt(tokens[2]);
                double grade = Double.parseDouble(tokens[3]);
                Student student = new Student(name, age, grade);
                create(student);
                break;

            case "Show":
                show(name);
                break;
        }
    }

    public  void create(Student student) {
        students.put(student.getName(), student);
    }

    public  void show(String name) {
        if (students.containsKey(name)) {
            Student student = students.get(name);
            String commentary = getCommentary(student.getGrade());
            System.out.printf("%s is %d years old. %s%n", student.getName(), student.getAge(), commentary);
        }
    }

    private static String getCommentary(double grade) {

        if (grade >= 5.00) {
            return " Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            return " Average student.";
        } else {
            return " Very nice person.";
        }
    }

}
