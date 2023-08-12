package challenge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        Path sourcePath = Paths.get("C:\\Users\\Raghu Reddy\\Documents\\PROGRAMMING\\CORE JAVA\\Java IO Streams\\challenge\\hello.txt");
        Path targetPath = Paths.get("C:\\Users\\Raghu Reddy\\Documents\\PROGRAMMING\\CORE JAVA\\Java IO Streams\\challenge\\hi.txt");

        try (
            FileInputStream fis = new FileInputStream(sourcePath.toString());
            FileOutputStream fos = new FileOutputStream(targetPath.toString())
        ) {
            // Read and process the data from the file
            int data;
            while ((data = fis.read()) != -1) {
                fos.write((char) data);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            // Handle any exceptions that occur during the process
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
