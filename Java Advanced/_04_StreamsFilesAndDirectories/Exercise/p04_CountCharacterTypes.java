package _04_StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.util.Set;

public class p04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String inputPath = "src/_04_StreamsFilesAndDirectories/Exercise/Resources/input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        String outputPath = "src/_04_StreamsFilesAndDirectories/Exercise/Output/04_output.txt";
        PrintWriter printer = new PrintWriter(outputPath);

        String line = reader.readLine();

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of(',', '.', '!', '?');
        Set<Character> whitespace = Set.of(' ');

        int vowelsCount = 0;
        int punctuationCount = 0;
        int otherSymbolsCount = 0;


        while (line != null) {
            char[] lineArr = line.toCharArray();
            for (char symbol : lineArr) {
                boolean isVowel = vowels.contains(symbol);
                boolean isPunctuation = punctuation.contains(symbol);
                boolean isWhitespace = whitespace.contains(symbol);
                if (isPunctuation) {
                    punctuationCount++;
                } else if (isVowel) {
                    vowelsCount++;
                } else if (!isWhitespace) {
                    otherSymbolsCount++;
                }
            }
            line = reader.readLine();
        }
        printer.println("Vowels: " + vowelsCount);
        printer.println("Other symbols: "+otherSymbolsCount);
        printer.println("Punctuation: "+punctuationCount);
        printer.close();
    }
}
