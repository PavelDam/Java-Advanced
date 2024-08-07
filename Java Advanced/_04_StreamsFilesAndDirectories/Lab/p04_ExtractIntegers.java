package _04_StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class p04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String pathToFile = "src/_04_StreamsFilesAndDirectories/Lab/Resources/input.txt";
        FileInputStream inputStream = new FileInputStream(pathToFile);

        String outputFile = "src/_04_StreamsFilesAndDirectories/Lab/Resources/output.txt";
        PrintWriter printer = new PrintWriter(new FileOutputStream(outputFile));
        Scanner scanner = new Scanner(inputStream);


        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printer.print(scanner.nextInt());
                printer.println();
            }
            scanner.next();
        }
        printer.flush();
    }
}
