package com.example;

import javax.swing.JFrame;

public class JFrameOne extends JFrame{

    public JFrameOne() {
        initialize();
    }

    public void initialize() {
        setTitle("JFrame One");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
