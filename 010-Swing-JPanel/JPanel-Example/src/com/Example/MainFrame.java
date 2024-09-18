package com.Example;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
    
    private JFrame frame;

    public MainFrame() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout(10,5));
        frame.setTitle("Java Swing Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        // panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        // panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.BLUE);

        Button button1 = new Button("Button 1");
        panel.add(button1);

        Button button2 = new Button("Button 2");
        panel.add(button2);
        
        Button button3 = new Button("Button 3");
        panel.add(button3);

        panel.setPreferredSize(new Dimension(250,250));

        // frame.add(panel, BorderLayout.EAST);
        // frame.add(panel, BorderLayout.NORTH);
        // frame.add(panel, BorderLayout.WEST);
        // frame.add(panel, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void show() {
        frame.setVisible(true);
    }
}
