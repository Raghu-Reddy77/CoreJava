//copying data from 1 to another file
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyChallenge {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("source1.txt");
                FileOutputStream fos = new FileOutputStream("source2.txt")) {

            int data;

            while ((data = fis.read()) != -1) {
               
               fos.write(Character.toUpperCase(data) );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
