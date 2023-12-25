package main.view;

import main.handlers.ServerHandler;
import main.view.components.FooterPanel;
import main.view.components.HeaderPanel;

import javax.swing.*;
import java.awt.*;

public class ServerGUI extends JFrame {

    private static final int COORD_X = 500;
    private static final int COORD_Y = 400;
    private static final int WIDTH = 640;
    private static final int HEIGHT = 400;

    private final JTextArea log = new JTextArea(10, 1);

    public ServerGUI(String title) {
        super(title);

        ServerHandler serverHandler = new ServerHandler();

        HeaderPanel headerPanel = new HeaderPanel();
        FooterPanel footerPanel = new FooterPanel(this, serverHandler, headerPanel.getPortNumber());

        add(headerPanel, BorderLayout.NORTH);
        add(log, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(COORD_X, COORD_Y, WIDTH, HEIGHT);
        setVisible(true);
        revalidate();
    }

    public void appendLog(String text) {
        log.append(text + "\n");
    }
}
