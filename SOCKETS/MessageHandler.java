package SOCKETS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Юля on 26.04.2016.
 */
public class MessageHandler implements Runnable {

    private Socket socket;

    public MessageHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Socket socket1 = this.socket;
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket1.getInputStream()))) {
            while (true) {
                String message = reader.readLine();
                if (message == null) {
                    break;
                }
                String nameOfThread = Thread.currentThread().getName();
                System.out.println(nameOfThread + ": "+message);
            }
        } catch (IOException ignored) {
        }
    }
}
