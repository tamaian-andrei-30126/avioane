package isp.lab9.ExemleProf.ExEu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel(String path) {
        this(new ImageIcon(path).getImage());
    }

    public ImagePanel(Image img) {
        this.image = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }

    public static void main(String[] args) {
        ImagePanel panel = new ImagePanel(
                new ImageIcon("docs/TMNSmartDoor.jpg").getImage());
        JLabel typeAccessCode;
        typeAccessCode = new JLabel("Type access code:");
        typeAccessCode.setBounds(400,250,90,20);
        JFrame frame = new JFrame();
        frame.add(typeAccessCode);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

    }

}