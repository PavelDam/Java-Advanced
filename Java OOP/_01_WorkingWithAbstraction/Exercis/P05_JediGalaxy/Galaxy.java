package _01_WorkingWithAbstraction.Exercise.P05_JediGalaxy;

public class Galaxy {
    private static int rows;
    private static int cols;

    private static int[][] galaxy;

    public Galaxy(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.galaxy = new int[rows][cols];
    }

    public static int[][] getGalaxy() {
        return galaxy;
    }

    public static int getRows() {
        return rows;
    }

    public static int getCols() {
        return cols;
    }

    public void create() {
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = value++;
            }
        }
    }
    public static boolean isInBounds(int row, int col) {
        return row >= 0 && row < galaxy.length && col >= 0 && col < galaxy[0].length;
    }
}
