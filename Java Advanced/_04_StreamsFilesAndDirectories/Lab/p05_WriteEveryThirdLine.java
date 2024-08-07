package _04_StreamsFilesAndDirectories.Lab;

import java.io.*;

public class p05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String inputFile = "src/_04_StreamsFilesAndDirectories/Lab/Resources/input.txt";
        String outputFile = "src/_04_StreamsFilesAndDirectories/Lab/Resources/output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter printer = new PrintWriter(new FileWriter(outputFile));
        String line = reader.readLine();
        int lineCounter = 1;
        while (line != null) {
            if (lineCounter % 3 == 0) {
                printer.print(line);
                printer.println();
            }

            line = reader.readLine();
            lineCounter++;
        }
        printer.flush();
    }
}
