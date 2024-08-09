package _04_StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class p07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path firstFile = Paths.get("src/_04_StreamsFilesAndDirectories/Exercise/Resources/inputOne.txt");
        List<String> firstFileList = Files.readAllLines(firstFile);

        Path secondFile = Paths.get("src/_04_StreamsFilesAndDirectories/Exercise/Resources/inputTwo.txt");
        List<String> secondFileList = Files.readAllLines(secondFile);

        Path output = Paths.get("src/_04_StreamsFilesAndDirectories/Exercise/Output/07_output.txt");
        Files.write(output,firstFileList, StandardOpenOption.APPEND);
        Files.write(output,secondFileList, StandardOpenOption.APPEND);



    }
}
