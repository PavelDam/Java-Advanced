package _01_WorkingWithAbstraction.Exercise.P05_JediGalaxy;

public class Jedi {
    private int[] coordinates;


    public Jedi(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public long move() {
        int row = coordinates[0];
        int col = coordinates[1];
        long starsCollected = 0;
        while (row >= 0 && col < Galaxy.getCols()) {
            if (Galaxy.isInBounds(row, col)) {
                starsCollected += Galaxy.getGalaxy()[row][col];
            }

            col++;
            row--;
        }
        return starsCollected;
    }
}
