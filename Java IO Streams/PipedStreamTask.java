import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Sender extends Thread {
    OutputStream os;

    Sender(OutputStream pos) {
        this.os = pos;
    }

    public void run() {
        try {
            String message = "hello";
            byte[] data = message.getBytes();
            os.write(data);
            System.out.println(new String(data));
            os.close(); // Close the output stream after sending
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Receiver extends Thread {
    InputStream is;

    Receiver(InputStream pis) {
        this.is = pis;
    }

    public void run() {
        try {
            byte[] data = new byte[1024]; // Create a buffer to read data
            int bytesRead;
            while ((bytesRead = is.read(data)) != -1) {
                String receivedMessage = new String(data, 0, bytesRead);
                System.out.println("Received: " + receivedMessage);
            }
            is.close(); // Close the input stream after receiving
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class PipedStreamTask {
    public static void main(String[] args) throws Exception {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect(pos);

        Sender sender = new Sender(pos);
        Receiver receiver = new Receiver(pis);

        sender.start();
        receiver.start();

        sender.join();
        receiver.join();
    }
}
