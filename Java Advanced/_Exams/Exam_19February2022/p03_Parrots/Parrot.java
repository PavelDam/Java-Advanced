package _Exams.Exam_19February2022.parrots;

public class Parrot {
    private String name;
    private String species;
    private boolean available;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s", species, name);
    }
}
