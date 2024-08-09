package _04_StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.util.*;

public class p06_WordCount {
    public static void main(String[] args) throws IOException {
        String wordsPath = "src/_04_StreamsFilesAndDirectories/Exercise/Resources/words.txt";
        Scanner wordScanner = new Scanner(new FileReader(wordsPath));


        String[] words = wordScanner.nextLine().split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, 0);
        }

        String textPath = "src/_04_StreamsFilesAndDirectories/Exercise/Resources/text.txt";
        Scanner fileScanner = new Scanner(new FileReader(textPath));
        String word = fileScanner.next();

        while (fileScanner.hasNext()) {

            if (map.containsKey(word)) {
                int occurrences = map.get(word);
                occurrences++;
                map.put(word, occurrences);

            }
            word = fileScanner.next();
        }


        String outputFile = "src/_04_StreamsFilesAndDirectories/Exercise/Output/06_output.txt";
        PrintWriter printer = new PrintWriter(outputFile);

        map.entrySet().stream().sorted((first, second) -> second.getValue() - first.getValue())
                .forEach(entry -> printer.printf("%s - %d%n", entry.getKey(), entry.getValue()));
        printer.close();
        fileScanner.close();
        wordScanner.close();
    }
}
