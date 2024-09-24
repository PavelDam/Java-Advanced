package _Exams.RetakeExam_15December2021.P03_WaterAdventure.aquarium;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String fish, String color, int fins) {
        this.name = fish;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }

    @Override
    public String toString() {
        return String.format("Fish: %s%nColor: %s%nNumber of fins: %d", name, color, fins);
    }
}
