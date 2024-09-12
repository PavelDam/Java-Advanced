package _Exams.Exam_23October2021.P03_HotelProblem.hotel;

public class Person {
    private String name;
    private int id;
    private int age;
    private String hometown;

    public Person(String name, int id, int age) {
        this(name, id, age, "n/a");
    }

    // Constructor with all parameters
    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }

    @Override
    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s", name, id, age, hometown);
    }
}
