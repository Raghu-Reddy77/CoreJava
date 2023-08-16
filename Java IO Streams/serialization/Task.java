package serialization;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Task {
    public static void main(String[] args) throws Exception {
        float list[] = { 12.4f, 4.8f, 5.9f, 6.8f, 8.9f, 9.7f };

        // Writing data to a file
        try (FileOutputStream fos = new FileOutputStream("data.txt");
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeInt(list.length); // Writing the length of the array
            for (float f : list) {
                dos.writeFloat(f); // Writing each float value to the file
            }
            System.out.println("Data writing completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Reading data from the file
        try (FileInputStream fis = new FileInputStream("data.txt");
             DataInputStream dis = new DataInputStream(fis)) {
            int length = dis.readInt(); // Reading the length of the array
            float readList[] = new float[length];
            for (int i = 0; i < length; i++) {
                readList[i] = dis.readFloat(); // Reading each float value from the file
            }
            
            // Displaying the read data
            System.out.println("Read data:");
            for (float b : readList) {
                System.out.println(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
