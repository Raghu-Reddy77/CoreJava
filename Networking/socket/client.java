package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) { 
        try {
            // Create a socket connection to the server at localhost and port 9999
            Socket socket = new Socket("localhost", 9999);
            
            // Get the output stream to send data to the server
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            
            // Send a message to the server
            String data = "Hello, server!";
            ps.println(data);
            
            // Get the input stream to receive data from the server
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = br.readLine();
            
            // Print the response received from the server
            System.out.println("Server response: " + response);
            
            // Close the socket connection
            socket.close();
        } catch (IOException e) {
            // Handle exceptions that may occur during socket communication
            e.printStackTrace();
        }
    }
}
