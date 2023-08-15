import java.io.File;

public class FileOperationsDemo {
    public static void main(String[] args) {
        // Creating a File object
        File file = new File("myfile.txt");

        // Checking existence
        if (file.exists()) {
            System.out.println("File exists");
        } else {
            System.out.println("File does not exist");
        }

        // Checking if it's a directory
        if (file.isDirectory()) {
            System.out.println("It's a directory");
        } else {
            System.out.println("It's not a directory");
        }

        // Creating a directory
        File directory = new File("mydir");
        if (directory.mkdir()) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Failed to create directory");
        }

        // Listing files and directories
        String[] fileList = directory.list();
        System.out.println("Files and directories in 'mydir':");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }

        // Deleting a file
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete file");
        }

        // Renaming a file
        File oldFile = new File("oldfile.txt");
        File newFile = new File("newfile.txt");
        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully");
        } else {
            System.out.println("Failed to rename file");
        }
    }
}
