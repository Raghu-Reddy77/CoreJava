package filetasks;
/*
File Information:
Write a program that takes a file path as input and 
displays the following information about the file:

File name
Absolute path
Size in bytes
Last modified timestamp

*/
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileInfo {

    public static void main(String[] args) {
        System.out.println("Enter file path:");
        Scanner sc = new Scanner(System.in);
        String PATH = sc.nextLine().replaceAll("\"", "");;
        sc.close();
        File file = new File(PATH);
        if(file.exists()) {
        	System.out.println("Filename: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("File Size: " + file.length() + " bytes");
            
            SimpleDateFormat date=new SimpleDateFormat("YYYY-MM-dd hh-mm-ss");
            System.out.println("Last modification: " + date.format(file.lastModified()));
        }else {
        	System.out.println("File not Exist or enter valid path");
        }
        
            
        
    }
}
