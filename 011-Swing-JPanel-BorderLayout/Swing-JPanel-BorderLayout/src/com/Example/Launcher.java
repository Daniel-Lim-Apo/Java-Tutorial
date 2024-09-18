package com.Example;

import javax.swing.SwingUtilities;

public class Launcher {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
                public void run() {
                    JPanelBorderLayout frame = new JPanelBorderLayout();
                    frame.show();
                }
            });
    }
}