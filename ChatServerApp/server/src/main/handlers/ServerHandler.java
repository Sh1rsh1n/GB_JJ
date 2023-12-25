package main.handlers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler {

    private ServerSocket serverSocket;

    private Socket socket;

    public ServerHandler() {
    }

    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            while (!serverSocket.isClosed()) {
                socket = serverSocket.accept();
                System.out.println("user is connected");
                UserConnectionHandler connect = new UserConnectionHandler(socket);
                Thread thread = new Thread(connect);
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("finish");
    }

    public void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
