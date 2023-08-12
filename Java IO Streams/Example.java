import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


class Example {
    public static void main(String[] args)  {
        try {
            FileReader fir=new FileReader("file.txt");
            int x;
            while((x=fir.read())!= -1){
                System.out.print((char)x);
            }
            fir.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
}