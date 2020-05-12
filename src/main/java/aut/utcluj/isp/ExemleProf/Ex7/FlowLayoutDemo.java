package isp.lab9.ExemleProf.Ex7;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.ComponentOrientation;

public class FlowLayoutDemo extends JFrame {

    public FlowLayoutDemo(String s) {
        setLayout(new FlowLayout());
        setTitle(s);
        add(new JButton("Button 1"));
        add(new JButton("Button 2"));
        add(new JButton("Button 3"));
        add(new JButton("Long-Named Button 4"));
        add(new JButton("5"));

        pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        new FlowLayoutDemo("flow demo");
    }
}