package filetasks;

import java.io.File;
import java.util.Scanner;

/* Directory Contents:
   Write a program that lists all files and subdirectories within a given directory.
   For each file, display its name and whether it's a file or directory.
*/
public class DirInfo {
    public static void main(String[] args) {
        // Get user input for directory path
        System.out.println("Enter dir path:");
        Scanner sc = new Scanner(System.in);
        String PATH = sc.nextLine().replaceAll("\"", "");
        sc.close();

        // Create a File object for the specified directory
        File dir = new File(PATH);

        // Check if the directory exists
        if (dir.exists() && dir.isDirectory()) {
            // List files and subdirectories within the directory
            File[] entries = dir.listFiles();

            // Iterate through the entries
            for (File entry : entries) {
                // Determine if the entry is a directory or a file
                if (entry.isDirectory()) {
                    System.out.println("Directory: " + entry.getName());

                    // List files and subdirectories within the subdirectory
                    File[] subEntries = entry.listFiles();
                    for (File subEntry : subEntries) {
                        System.out.println("   " + subEntry.getName());
                    }
                } else if (entry.isFile()) {
                    System.out.println("File: " + entry.getName());
                }
            }
        } else {
            System.out.println("Directory does not exist or invalid path");
        }
    }
}
