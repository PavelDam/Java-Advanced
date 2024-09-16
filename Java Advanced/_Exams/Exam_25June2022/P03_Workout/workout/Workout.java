package _Exams.Exam_25June2022.P03_Workout.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exerciseList;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exerciseList = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exerciseList.size() < exerciseCount) {
            exerciseList.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exerciseList.removeIf(e -> e.getName().equals(name) && e.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        return exerciseList.stream()
                .filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exerciseList.stream()
                .max(Comparator.comparing(Exercise::getBurnedCalories))
                .orElse(null);
    }

    public int getExerciseCount() {
        return exerciseList.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n", type));

        exerciseList.forEach(ex -> sb.append(ex).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
