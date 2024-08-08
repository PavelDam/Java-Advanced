package _04_StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p01_SumLines {
    public static void main(String[] args) throws IOException {

        String filePath = "src/_04_StreamsFilesAndDirectories/Exercise/Resources/input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line = reader.readLine();

        while (line != null) {
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                int symbol = line.toCharArray()[i];
                sum += symbol;
            }
            System.out.println(sum);
            line = reader.readLine();
        }
    }
}
