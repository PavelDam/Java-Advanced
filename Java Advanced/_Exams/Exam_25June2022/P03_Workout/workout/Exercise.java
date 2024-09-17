package _Exams.Exam_25June2022.P03_Workout.workout;

public class Exercise {
    private String name;
    private String muscle;
    private int burnedCalories;

    public Exercise(String name, String muscle, int burnedCalories) {
        this.name = name;
        this.muscle = muscle;
        this.burnedCalories = burnedCalories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public void setBurnedCalories(int burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

    public String getName() {
        return name;
    }

    public String getMuscle() {
        return muscle;
    }

    public int getBurnedCalories() {
        return burnedCalories;
    }

    @Override
    public String toString() {
        return String.format("Exercise %s, %s, %d",name,muscle,burnedCalories);
    }
}