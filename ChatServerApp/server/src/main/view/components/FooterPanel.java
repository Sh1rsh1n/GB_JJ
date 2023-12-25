package main.view.components;

import main.handlers.ServerHandler;
import main.view.ServerGUI;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends JPanel {

    private JButton btnStart, btnStop;

    public FooterPanel(ServerGUI serverGUI, ServerHandler serverHandler, int port) {

        setLayout(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        add(btnStart);
        add(btnStop);

        btnStart.addActionListener(e -> {
            serverGUI.appendLog("Сервер запушен");
            serverHandler.startServer(port);
        });

        btnStop.addActionListener(e -> {
            serverGUI.appendLog("Сервер остановлен");
            serverHandler.stopServer();
        });
    }
}
