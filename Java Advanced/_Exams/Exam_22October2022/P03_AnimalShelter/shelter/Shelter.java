package _Exams.Exam_22October2022.P03_AnimalShelter.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {

        return data.removeIf(animal -> animal.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return data.stream()
                .filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker))
                .findFirst()
                .orElse(null);
    }

    public Animal getOldestAnimal() {
        return data.stream()
                .max(Comparator.comparing(Animal::getAge))
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The shelter has the following animals:").append(System.lineSeparator());
        data.forEach(a -> builder.append(a.getName()).append(" ").append(a.getCaretaker()).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}