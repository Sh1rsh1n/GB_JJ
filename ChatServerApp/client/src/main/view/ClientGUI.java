package main.view;

import main.view.handlers.ClientHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;

public class ClientGUI extends JFrame {

    private static final int COORD_X = 600;
    private static final int COORD_Y = 500;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 480;

    private JTextArea log;
    private JTextField ipAddress, port, nikName, message;
    private JButton connectBtn, disconnectBtn, btnSend;
    private JPanel headerPanel;

    private Socket socket;
    private ClientHandler clientHandler;

    public ClientGUI(String title) {
        super(title);

        setBounds(COORD_X, COORD_Y, WIDTH, HEIGHT);

        createPanel();

        setVisible(true);

        revalidate();

    }

    public void appendLog(String text) {
        log.append(text + "\n");
    }

    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private Component createHeaderPanel() {
        headerPanel = new JPanel(new GridLayout(2, 3));
        ipAddress = new JTextField("127.0.0.1");
        port = new JTextField("9999");
        nikName = new JTextField("Алекс");
        connectBtn = new JButton("Подключиться");
        disconnectBtn = new JButton("Отключиться");
        disconnectBtn.setEnabled(false);
        connectBtn.addActionListener(e -> connectToServer());
        disconnectBtn.addActionListener(e -> disconnectFromServer());

        headerPanel.add(ipAddress);
        headerPanel.add(port);
        headerPanel.add(new JPanel());
        headerPanel.add(nikName);
        headerPanel.add(connectBtn);
        headerPanel.add(disconnectBtn);

        return headerPanel;
    }

    private Component createFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        message = new JTextField();
        message.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    sendMessage();
                }
            }
        });
        btnSend = new JButton("Отправить");
        btnSend.addActionListener(e -> sendMessage());
        panel.add(message);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    private void connectToServer() {
            clientHandler = new ClientHandler(socket, this);
            clientHandler.listenForMessage();
    }

    public void disconnectFromServer() {
        try {
            socket.close();
            if (!socket.isConnected()) {
                connectBtn.setEnabled(true);
                disconnectBtn.setEnabled(false);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage() {
        clientHandler.sendMessage(message.getText());
    }

    public String getIpAddress() {
        return ipAddress.getText();
    }

    public String getUserName() {
        return nikName.getText();
    }

    public int getPort() {
        return Integer.parseInt(port.getText());
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            disconnectFromServer();
        }
    }
}
