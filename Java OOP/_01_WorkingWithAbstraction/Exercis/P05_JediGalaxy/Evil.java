package _01_WorkingWithAbstraction.Exercise.P05_JediGalaxy;

public class Evil {
    private int[] coordinates;


    public Evil(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void move() {
        int row = coordinates[0];
        int col = coordinates[1];

        while (row >= 0 && col >= 0) {
            if (Galaxy.isInBounds(row, col)) {
                Galaxy.getGalaxy()[row][col] = 0;
            }
            row--;
            col--;
        }
    }
}
