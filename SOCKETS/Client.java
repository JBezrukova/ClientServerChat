package SOCKETS;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Юля on 22.04.2016.
 */
public class Client {

    public static void main(String[] args) {

        Client client = new Client();
        client.start();
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            if (message.equals("exit")) {
                break;
            }
            send(message);
        }
    }

    public void send(String messge) {
        try (Socket socket = new Socket("192.168.1.111", 3502);
             OutputStream outputStream = socket.getOutputStream()) {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.print(messge);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
