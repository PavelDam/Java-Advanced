package _Exams.Exam_22October2022.P03_AnimalShelter.shelter;

public class Animal {
    private String name;
    private int age;
    private String caretaker;

    public Animal(String name, int age, String caretaker) {
        this.name = name;
        this.age = age;
        this.caretaker = caretaker;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCaretaker() {
        return caretaker;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", name, age, caretaker);
    }
}
