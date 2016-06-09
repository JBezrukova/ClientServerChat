package SOCKETS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Юля on 26.04.2016.
 */
public class MultithreadedServer {

    public static void main(String[] args) {
        MultithreadedServer multithreadedServer = new MultithreadedServer();
        multithreadedServer.start();
    }

    private ServerSocket serverSocket;

    public MultithreadedServer() {
        try {
            serverSocket = new ServerSocket(3502);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                MessageHandler messageHandler = new MessageHandler(socket);
                Thread thread = new Thread(messageHandler);
                String threadName = thread.currentThread().getName();
                System.out.println(threadName+" :created"+" "+ thread.getName());
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
