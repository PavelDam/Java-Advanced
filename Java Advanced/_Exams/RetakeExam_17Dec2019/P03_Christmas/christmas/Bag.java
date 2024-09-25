package _Exams.RetakeExam_17Dec2019.P03_Christmas.christmas;

import _Exams.RetakeExam_18August2021.P03_Cafe.cafe.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (data.size() < capacity) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(present -> present.getName().equals(name));
    }

    public Present heaviestPresent() {
        return data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String name) {
        return data.stream().filter(present -> present.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:%n", color));
        data.forEach(present -> sb.append(present).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
