package _02_MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P06_StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        int degree = getDegree(rotation);

        List<String> inputList = new ArrayList<>();
        getInput(inputList, scanner);

        int rows = inputList.size();
        int cols = getCols(inputList);


        fillMatrix(inputList, degree, rows, cols);


    }

    private static void fillMatrix(List<String> inputList, int degree, int rows, int cols) {
        if (degree >= 360) {
            degree = degree % 360;
        }

        switch (degree) {
            case 0:
                char[][] matrix = new char[rows][cols];
                for (int row = 0; row < matrix.length; row++) {
                    String s = inputList.get(row);
                    for (int col = 0; col < matrix[row].length; col++) {
                        if (col > s.length() - 1) {
                            matrix[row][col] = ' ';
                        } else {
                            matrix[row][col] = s.charAt(col);
                        }
                    }
                }
                printMatrix(matrix);
                break;
            case 90:
                char[][] matrix90 = new char[cols][rows];
                for (int col = rows - 1, word = 0; col >= 0 && word < inputList.size(); col--, word++) {
                    String s = inputList.get(word);
                    for (int row = 0; row < cols; row++) {
                        if (row > s.length() - 1) {
                            matrix90[row][col] = ' ';
                        } else {
                            matrix90[row][col] = s.charAt(row);
                        }
                    }
                }
                printMatrix(matrix90);
                break;
            case 180:
                char[][] matrix180 = new char[rows][cols];
                for (int row = matrix180.length - 1, word = 0; row >= 0 && word < inputList.size(); row--, word++) {
                    String s = inputList.get(word);

                    for (int col = matrix180[row].length - 1, charCount = 0; col >= 0 && charCount < cols; col--, charCount++) {
                        if (charCount > s.length() - 1) {
                            matrix180[row][col] = ' ';
                        } else {
                            matrix180[row][col] = s.charAt(charCount);
                        }
                    }
                }
                printMatrix(matrix180);
                break;
            case 270:
                char[][] matrix270 = new char[cols][rows];
                for (int col = 0; col < rows; col++) {
                    String s = inputList.get(col);

                    for (int row = cols - 1, charCount = 0; row >= 0 && charCount < cols; row--, charCount++) {
                        if (charCount > s.length() - 1) {
                            matrix270[row][col] = ' ';
                        } else {
                            matrix270[row][col] = s.charAt(charCount);
                        }
                    }
                }
                printMatrix(matrix270);
                break;
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static int getCols(List<String> inputList) {
        int cols = 0;
        for (String s : inputList) {
            int currentWordLength = s.length();
            if (currentWordLength > cols) {
                cols = currentWordLength;
            }
        }
        return cols;
    }

    private static void getInput(List<String> inputList, Scanner scanner) {

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            inputList.add(input);
            input = scanner.nextLine();
        }

    }

    private static int getDegree(String rotation) {
        int startIndex = rotation.indexOf('(');
        int endIndex = rotation.indexOf(')');
        return Integer.parseInt(rotation.substring(startIndex + 1, endIndex));
    }
}
