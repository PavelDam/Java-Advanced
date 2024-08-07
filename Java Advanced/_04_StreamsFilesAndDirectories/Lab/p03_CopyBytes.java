package _04_StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Set;

public class p03_CopyBytes {
    public static void main(String[] args) throws IOException {
        String pathToFile = "src/_04_StreamsFilesAndDirectories/Lab/Resources/input.txt";


        FileInputStream fileInputStream = new FileInputStream(pathToFile);

        FileOutputStream fileOutputStream = new FileOutputStream("src/_04_StreamsFilesAndDirectories/Lab/Resources/output.txt");

        PrintWriter printer = new PrintWriter(fileOutputStream);

        int oneByte = fileInputStream.read();

        Set<Integer> delimiter = Set.of(10, 32);

        while (oneByte != -1) {

            boolean isDelimiter = delimiter.contains(oneByte);

            if (isDelimiter) {
                printer.print((char) oneByte);
            } else {
                String digits = String.valueOf(oneByte);
                printer.print(digits);
            }

            oneByte = fileInputStream.read();
        }
        printer.flush();
    }
}
