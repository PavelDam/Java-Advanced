package _Exams.RetakeExam_14December2022.P03_SoftUniStudents.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        if (data.size() < capacity) {
            if (!data.contains(student)) {
                data.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            } else {
                return "Student is already in the hall.";
            }
        } else {
            return "The hall is full.";
        }
    }

    public String remove(Student student) {
        if (data.remove(student)) {
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return data.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hall size: %d", data.size())).append(System.lineSeparator());
        data.forEach(s -> sb.append(s).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
