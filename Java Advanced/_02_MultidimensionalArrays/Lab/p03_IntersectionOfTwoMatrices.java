package _02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == 0) {
                    firstMatrix[j] = scanner.nextLine().toCharArray();
                } else {
                    secondMatrix[j] = scanner.nextLine().toCharArray();
                }
            }
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[row].length; col++) {
                char firstM = firstMatrix[row][col];
                char secondM = secondMatrix[row][col];

                System.out.print(firstM == secondM ? firstM : '*');
            }
            System.out.println();
        }
    }
}
