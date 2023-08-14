import java.io.*;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws Exception {
        // Create a RandomAccessFile named "data.txt" in read-write mode
        RandomAccessFile file = new RandomAccessFile("data.txt", "rw");

        // Display the initial length of the file
        System.out.println("Initial file length: " + file.length());

        // Set the length of the file to 30 bytes
        file.setLength(30);
        System.out.println("Updated file length: " + file.length());

        // Read and print the first character in the file (byte)
        System.out.println("First character: " + (char) file.read());

        // Skip 10 bytes from the current position
        file.skipBytes(10);
        System.out.println("Current file pointer position: " + file.getFilePointer());

        // Read and print the next byte from the current position
        int data = file.read();
        System.out.println("Next byte: " + data + " (" + (char) data + ")");

        // Close the file
        file.close();
    }
}
