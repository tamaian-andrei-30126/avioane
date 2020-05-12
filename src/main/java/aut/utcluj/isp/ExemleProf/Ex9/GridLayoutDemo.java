package isp.lab9.ExemleProf.Ex9;


import java.awt.*;
import javax.swing.*;

public class GridLayoutDemo extends JFrame {

    public GridLayoutDemo() {

        setLayout(new GridLayout(2, 2));
        add(new JButton("Button 1"));
        add(new JButton("Button 2"));
        add(new JButton("Button 3"));
        add(new JButton("Long-Named Button 4"));

        pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        new GridLayoutDemo();
    }
}
