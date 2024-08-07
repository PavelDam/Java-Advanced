package _04_StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Set;

public class p02_WriteToFile {
    public static void main(String[] args) throws IOException {
        String pathToFile = "src/_04_StreamsFilesAndDirectories/Lab/Resources/input.txt";

        FileInputStream fileInputStream = new FileInputStream(pathToFile);

        int oneByte = fileInputStream.read();
        Set<Character> punctuation = Set.of('.', ',', '!', '?');

        while (oneByte != -1) {
            char symbol = (char) oneByte;
            boolean isPunctuation = punctuation.contains(symbol);

            if (!isPunctuation){
                System.out.print(symbol);
            }
            oneByte = fileInputStream.read();
        }

    }
}
