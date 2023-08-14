import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * PipedStream Example: Demonstrating communication between producer and consumer using piped streams.
 */

class Producer extends Thread {
    OutputStream os;

    Producer(OutputStream pos) {
        this.os = pos;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                os.write(i);
                System.out.println("Produces " + i);
                System.out.flush(); // Flush output to immediately display data
                Thread.sleep(10); // Introduce a small delay
            }
        } catch (Exception e) {
            // Handle exceptions
        }
    }
}

class Consumer extends Thread {
    InputStream is;

    Consumer(InputStream pis) {
        this.is = pis;
    }

    public void run() {
        int x;
        try {
            while ((x = is.read()) != -1) {
                System.out.println("Consumes " + x);
                System.out.flush(); // Flush output to immediately display data
                Thread.sleep(10); // Introduce a small delay
            }
        } catch (Exception e) {
            // Handle exceptions
        }
    }
}

public class PipedStream {

    public static void main(String[] args) throws Exception {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect(pos);

        Producer p = new Producer(pos);
        Consumer c = new Consumer(pis);

        p.start();
        c.start();

        p.join(); // Wait for producer thread to finish
        c.join(); // Wait for consumer thread to finish
    }
}
