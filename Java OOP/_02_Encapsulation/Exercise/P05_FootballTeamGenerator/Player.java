package _02_Encapsulation.Exercise.P05_FootballTeamGenerator;

import _02_Encapsulation.Exercise.P04_PizzaCalories.Dough;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        statsValidation(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        statsValidation(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        statsValidation(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        statsValidation(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        statsValidation(shooting, "Shooting");
        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) * 1.00 / 5;
    }

    private static void statsValidation(int stat, String statType) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(statType + " should be between 0 and 100.");
        }
    }
}
