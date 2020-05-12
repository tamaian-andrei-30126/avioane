package isp.lab9.ExemleProf.Ex8;


import java.awt.*;

import javax.swing.JFrame;

public class TestBorderLayout {
    public static void main(String args[]) {
        JFrame f = new JFrame("Border Layout");
        f.setLayout(new BorderLayout());//poate sa lipseasca

        f.add(new Button("Nord"), BorderLayout.NORTH);
        f.add(new Button("Sud"), BorderLayout.SOUTH);
        f.add(new Button("Est"), BorderLayout.EAST);
        f.add(new Button("Vest"), BorderLayout.WEST);
        f.add(new Button("Centru"), BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}