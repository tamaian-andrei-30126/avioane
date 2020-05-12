package isp.lab9.ExemleProf.Ex4;

import javax.swing.*;
import java.awt.*;

class Polygon1Panel extends JPanel {
    int fWidth, fHeight;
    int fNumPoints;
    double fFactor;

    Polygon1Panel(int width, int height, int nPoints) {
        fNumPoints = nPoints;
        fWidth = width;
        fHeight = height;
        fFactor = 2.0 * Math.PI / fWidth;
        this.setPreferredSize(new Dimension(width, height));
    } // ctor

    public void paintComponent(Graphics g) {
        // First paint background unless you will
        // paint whole area yourself.
        super.paintComponent(g);

        // Create arrays of points for each
        // segment of the polygon
        int[] x = new int[fNumPoints];
        int[] y = new int[fNumPoints];

        // Select horizontal step size
        double x_del = ((double) fWidth) / (fNumPoints - 1);

        // Find coordinates of the display center
        int x_offset = fWidth / 2;
        int y_offset = fHeight / 2;

        // Choose amplitude for the sine curve
        int amp = (int) (y_offset * 0.9);

        // Create a sine curve from a sequence
        // of short line segments
        for (int i = 0; i < fNumPoints; i++) {
            x[i] = (int) (i * x_del);
            y[i] = (int) (amp * Math.sin(fFactor * x[i]))
                    + y_offset;
        }

        // Set the line color to red
        g.setColor(Color.red);

        // Draw curve with single call to drawPolyline
        g.drawPolyline(x, y, fNumPoints);

        // Change the line color and draw the x-y axes
        g.setColor(Color.green);
        g.drawLine(0, y_offset, fWidth - 1, y_offset);
        g.drawLine(x_offset, 0, x_offset, fHeight - 1);

    } // paintComponent

} // class Polygon1Panel
