package SOCKETS;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Юля on 26.04.2016.
 */
public class SlowClient {

    public static void main(String[] args) {
        SlowClient slowClient = new SlowClient();
        slowClient.start();
    }

    private Socket socket;

    public SlowClient() {
        try {
            socket = new Socket("192.168.1.111", 3502);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void start() {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream());
             Scanner scanner2 = new Scanner(System.in)) {
            while (true) {
                String message = scanner2.nextLine();
                if (message.equals("exit")) {
                    break;
                }
                writer.print(message);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
