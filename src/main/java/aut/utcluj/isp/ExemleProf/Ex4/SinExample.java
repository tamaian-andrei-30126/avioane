package isp.lab9.ExemleProf.Ex4;


import javax.swing.*;
import java.awt.*;

/**
 * Example demonstrating drawPolyline().
 */
public class SinExample extends JFrame {
    public SinExample() {


        this.setSize(new Dimension(1000, 700));
        int width = getSize().width;
        int height = getSize().height;

        int num_points = 21;

        // Create an instance of DrawingPanel
        Polygon1Panel polygon1_panel =
                new Polygon1Panel(width, height, num_points);
        // Add the DrawingPanel to the contentPane.
        add(polygon1_panel);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new SinExample();
    }
}