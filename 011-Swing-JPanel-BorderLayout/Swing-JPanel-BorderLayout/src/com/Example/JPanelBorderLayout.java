package com.Example;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class JPanelBorderLayout {

    private JFrame frame;

    public JPanelBorderLayout() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout(10,5));
        frame.setTitle("Java Swing JPanel BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(10);
        borderLayout.setVgap(10);

        frame.setLayout(borderLayout);

        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void show() {
        frame.setVisible(true);
    }

}
