package _04_StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class p06_SortLines {
    public static void main(String[] args) throws IOException {
        String inputFile = "src/_04_StreamsFilesAndDirectories/Lab/Resources/input.txt";
        Path path = Paths.get(inputFile);
        String outputFile = "src/_04_StreamsFilesAndDirectories/Lab/Resources/output.txt";
        PrintWriter printer = new PrintWriter(new FileWriter(outputFile));

        Stream<String> lines = Files.lines(path);

        Stream<String> sortedLines = lines.sorted();

        sortedLines.forEach(line -> {
            printer.print(line);
            printer.println();
        });
        printer.flush();
    }
}
