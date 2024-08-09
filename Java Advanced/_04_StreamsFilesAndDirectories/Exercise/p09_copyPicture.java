package _04_StreamsFilesAndDirectories.Exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class p09_copyPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\pavel\\OneDrive\\Desktop\\3.Advanced\\01. ADVANCED - януари 2023\\4. Streams, Files and Directories\\Streams Files and Directories.png");

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\pavel\\OneDrive\\Desktop\\3.Advanced\\01. ADVANCED - януари 2023\\4. Streams, Files and Directories\\Streams Files and Directories Copy.png");
        byte[] buffer = new byte[1024];
        while (inputStream.read(buffer)>=0){
            outputStream.write(buffer);
        }
    }
}
