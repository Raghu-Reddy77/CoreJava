// Copying data from two files to a single file using SequenceInputStream

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;

public class Copy2 {
    public static void main(String[] args) {
        try (
            // Open the input streams for source1.txt and source2.txt
            FileInputStream fis = new FileInputStream("source1.txt");
            FileInputStream fis1 = new FileInputStream("source2.txt");
            
            // Create a SequenceInputStream to read from both input streams sequentially
            SequenceInputStream sis = new SequenceInputStream(fis, fis1);
            
            // Open the output stream for source3.txt
            FileOutputStream fos = new FileOutputStream("source3.txt")
        ) {
            int data;
            // Read data from the SequenceInputStream and write to source3.txt
            while ((data = sis.read()) != -1) {
                fos.write(data);
            }
        } catch (Exception e) {
            // Print any exceptions that occur during the process
            System.out.println(e);
        }
    }
}
