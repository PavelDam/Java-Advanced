package _04_StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class p03_AllCapitals {
    public static void main(String[] args) throws IOException, RuntimeException {

        String filePath = "src/_04_StreamsFilesAndDirectories/Exercise/Resources/input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        PrintWriter printer = new PrintWriter("src/_04_StreamsFilesAndDirectories/Exercise/Output/03_output.txt");

        String line = reader.readLine();


        while (line != null) {
            String uppercase = line.toUpperCase();
            printer.println(uppercase);

            line = reader.readLine();
        }
        printer.close();

    }
}
