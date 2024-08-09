package _04_StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;

public class p08_GetFolderSize {
    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Users\\pavel\\OneDrive\\Desktop\\3.Advanced\\01. ADVANCED - януари 2023\\4. Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources");
        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(folder);

        int sumOfBytes = 0;

        while (!directories.isEmpty()) {
            File current = directories.poll();
            File[] files = current.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                } else {
                    sumOfBytes += file.length();
                }
            }
        }
        PrintWriter writer = new PrintWriter("src/_04_StreamsFilesAndDirectories/Exercise/Output/08_output.txt");
        writer.println("Folder size: " + sumOfBytes);
        writer.close();
    }
}
