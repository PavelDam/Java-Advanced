package _06_DefiningClasses.Exercise.P09_CatLady;

public class Cat {
    private String name;
    private String breed;
    private double number;

    public Cat(String name, String breed, double number) {
        this.name = name;
        this.breed = breed;
        this.number = number;
    }


    @Override
    public String toString() {
        return String.format("%s %s %.2f", breed, name,number);
    }
}
