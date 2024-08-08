package _04_StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class p02_SumBytes {
    public static void main(String[] args) throws IOException {
        String filePath = "src/_04_StreamsFilesAndDirectories/Exercise/Resources/input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line = reader.readLine();
        long sum = 0;

        while (line != null) {

            for (int i = 0; i < line.length(); i++) {
                int current = line.toCharArray()[i];
                sum += current;
            }
            line = reader.readLine();
        }
//        FileInputStream inputStream = new FileInputStream(filePath);
//        long sum = 0;
//        int currentByte = inputStream.read();
//        Set<Integer> symbols = Set.of(10,13);
//        while (currentByte >= 0) {
//
//            boolean isSymbol = symbols.contains(currentByte);
//
//            if (!isSymbol){
//                sum += currentByte;
//            }
//            currentByte = inputStream.read();
//        }
        System.out.println(sum);
    }
}
