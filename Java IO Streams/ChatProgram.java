import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

class Sender extends Thread {
    private PipedOutputStream outStream;

    public Sender(PipedOutputStream outStream) {
        this.outStream = outStream;
    }

    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();
                outStream.write(message.getBytes());
                outStream.write('\n'); // Add newline character
                outStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Receiver extends Thread {
    private PipedInputStream inStream;

    public Receiver(PipedInputStream inStream) {
        this.inStream = inStream;
    }

    public void run() {
        try {
            while (true) {
                StringBuilder receivedMessage = new StringBuilder();
                int ch;
                while ((ch = inStream.read()) != -1 && ch != '\n') {
                    receivedMessage.append((char) ch);
                }
                System.out.println("Friend: " + receivedMessage.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ChatProgram {
    public static void main(String[] args) {
        try {
            PipedOutputStream senderToReceiver = new PipedOutputStream();
            PipedOutputStream receiverToSender = new PipedOutputStream();
            PipedInputStream receiverInputStream = new PipedInputStream(senderToReceiver);
            PipedInputStream senderInputStream = new PipedInputStream(receiverToSender);

            Sender senderThread = new Sender(senderToReceiver);
            Receiver receiverThread = new Receiver(receiverInputStream);

            senderThread.start();
            receiverThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
