package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

// Serializable class to represent customer data
class Customer implements Serializable {
    String cName;
    int cAge;
    int cNumber;
    String cId;
    static int count = 0;

    public Customer(String cName, int cAge, int cNumber) {
        super();
        this.cName = cName;
        this.cAge = cAge;
        this.cNumber = cNumber;
        this.cId = "C" + ++count; // Generate unique customer ID
    }

    @Override
    public String toString() {
        return "Customer [cName=" + cName + ", cAge=" + cAge + ", cNumber=" + cNumber + ", cId=" + cId + "]";
    }
}

public class Task2 {

    public static void main(String[] args) throws Exception {
        // Create an array of Customer objects
        Customer cObj[] = { 
            new Customer("Raghu", 20, 12345678), 
            new Customer("Renuka", 20, 12845678),
            new Customer("Shukesh", 20, 12345678) 
        };

        // Write customer data to a file
        FileOutputStream fos = new FileOutputStream("cData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeInt(cObj.length); // Write the number of customers to the file
        for (Customer b : cObj) {
            oos.writeObject(b); // Write each customer object to the file
        }
        System.out.println("Customer data copied Successfully ");
        oos.close();
        fos.close();

        // Read and display customer data from the file
        FileInputStream fis = new FileInputStream("cData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        int length = ois.readInt(); // Read the number of customers from the file

        Customer list[] = new Customer[length]; // Array to store read customer objects

        // Read each customer object from the file and store in the array
        for (int i = 0; i < length; i++) {
            list[i] = (Customer) ois.readObject();
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        sc.close();

        // Search for a customer by name and print their details
        for (int i = 0; i < list.length; i++) {
            if (name.equalsIgnoreCase(list[i].cName))
                System.out.println(list[i]);
        }
    }
}
