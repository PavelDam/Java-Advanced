package _04_StreamsFilesAndDirectories.Lab;

import java.io.*;

public class p01_ReadFile {
    public static void main(String[] args) {
        String pathToFile = "src/_04_StreamsFilesAndDirectories/Lab/Resources/input.txt";

        try (FileInputStream inputStream = new FileInputStream(pathToFile)) {
            int currentByte = inputStream.read();
            while (currentByte>=0){
                System.out.print(Integer.toBinaryString(currentByte)+" ");
                currentByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
