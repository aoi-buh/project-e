package com.example;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow {

    private JPanel panel;
    private JFrame frame;


    public GameWindow() {

        this.panel = new JPanel() {
            
            public void paintBackGroud() {
                
            }

            public void paint(Graphics graphics) {

            }
        };





        this.frame = new JFrame();





        this.frame.add(panel);
    }


}
