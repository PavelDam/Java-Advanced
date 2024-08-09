package _04_StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class p05_LineNumbers {
    public static void main(String[] args) throws IOException {

        String inputPath = "src/_04_StreamsFilesAndDirectories/Exercise/Resources/inputLineNumbers.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        String outputPath = "src/_04_StreamsFilesAndDirectories/Exercise/Output/05_output.txt";
        PrintWriter printer = new PrintWriter(outputPath);

        String line = reader.readLine();
        int lineCounter = 1;
        while (line != null) {

            printer.println(lineCounter + ". " + line);

            line = reader.readLine();
            lineCounter++;
        }
        printer.close();
    }
}
