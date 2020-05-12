package isp.lab9.ExemleProf.Ex3;

import javax.swing.*;
import java.awt.*;

public class JScrollListExample extends JFrame {

    JScrollPane scrollpane;

    public JScrollListExample() {
        super("JScrollPane Demonstration");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String categories[] = {"Household", "Office", "Extended Family",
                "Company (US)", "Company (World)", "Team",
                "Will", "Birthday Card List", "High School",
                "Country", "Continent", "Planet"};
        JList list = new JList(categories);
        scrollpane = new JScrollPane(list);

        getContentPane().add(scrollpane, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        JScrollListExample sl = new JScrollListExample();
        sl.setVisible(true);
    }
}