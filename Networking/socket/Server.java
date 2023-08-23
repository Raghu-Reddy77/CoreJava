package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // Create a server socket on port 9999
        ServerSocket ss = new ServerSocket(9999);

        // Wait for a client to connect and accept the connection
        Socket clientSocket = ss.accept();
        
        // Get input stream to receive data from the client
        InputStream is = clientSocket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        // Read the client's message
        String clientMessage = br.readLine();
        System.out.println("Client message: " + clientMessage);
        
        // Get output stream to send data back to the client
        OutputStream os = clientSocket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        
        // Respond to the client's message
        String response = "Message received: " + clientMessage;
        ps.println(response);

        // Close the client socket and server socket
        clientSocket.close();
        ss.close();
    }
}
