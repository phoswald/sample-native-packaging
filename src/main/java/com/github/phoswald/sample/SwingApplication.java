package com.github.phoswald.sample;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingApplication extends JFrame {
    
    private static final long serialVersionUID = 1L;

    public SwingApplication() {
        super("SwingApplication");
        initComponents();
        setMinimumSize(new Dimension(640, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }
    
    private void initComponents() {
        JLabel label = new JLabel("Hello World", JLabel.CENTER);
        getContentPane().add(label);
    }

    public static void main(String[] args) {
        new SwingApplication().setVisible(true);
    }
}
