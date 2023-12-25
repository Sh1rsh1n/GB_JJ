package main.view.components;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    private JLabel label;
    private JTextField port;

    public HeaderPanel() {
        setLayout(new GridLayout(1, 2));
        label = new JLabel("PORT");
        port = new JTextField("9999");
        add(label);
        add(port);
    }

    public Integer getPortNumber() {
        return Integer.parseInt(port.getText());
    }
}
