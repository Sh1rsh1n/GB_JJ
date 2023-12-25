package main.view.handlers;

import main.view.ClientGUI;

import java.io.*;
import java.net.Socket;

public class ClientHandler {

    private final Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String name;

    private final ClientGUI clientGUI;

    public ClientHandler(Socket socket, ClientGUI clientGUI) {
        this.socket = socket;
        this.clientGUI = clientGUI;

        try {
            socket = new Socket(clientGUI.getIpAddress(), clientGUI.getPort());
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            String helloMessage = "Привет всем от " + clientGUI.getUserName();
            printWriter.println(helloMessage);
            System.out.println("C: " + bufferedReader.readLine());
            clientGUI.appendLog(helloMessage);
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMessage() {
        new Thread(() -> {
            String message;
            while (socket.isConnected()) {
                try {
                    message = bufferedReader.readLine();
                    clientGUI.appendLog(message);
                } catch (IOException e) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }
        }).start();
    }

    public void sendMessage(String message) {
        try {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            while (socket.isConnected()) {
                bufferedWriter.write(name + ": " + message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
