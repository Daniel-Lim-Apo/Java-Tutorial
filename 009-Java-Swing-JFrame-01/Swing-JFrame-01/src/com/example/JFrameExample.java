package com.example;

import javax.swing.SwingUtilities;

public class JFrameExample {
    public static void main(String[] args) throws Exception {
       SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {

            JFrameOne frameOne = new JFrameOne();
            
            JFrameTwo frameTwo = new JFrameTwo();
            
       }
    });
}
}
