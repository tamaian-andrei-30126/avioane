package isp.lab9.ExemleProf.ExEu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame implements ActionListener {

    private JTextField accessCode;
    private JButton enterCode;
    private JTextField doorStatus;
    private ImagePanel panel;

    public User(JFrame frame) {
        accessCode = new JTextField();
        accessCode.setBounds(420,170,400,70);
        accessCode.setFont(new Font("Dialog",Font.PLAIN,30));;
        frame.add(accessCode);

        enterCode = new JButton("Enter code");
        enterCode.setBounds(420,270,400,70);
        System.out.println(enterCode.getFont());
        enterCode.setFont(new Font("Dialog",Font.PLAIN,30));;
        frame.add(enterCode);

        doorStatus = new JTextField("Door Locked");
        doorStatus.setBounds(420,420,400,70);
        System.out.println(doorStatus.getFont());
        doorStatus.setFont(new Font("Dialog",Font.PLAIN,30));;
        doorStatus.setEditable(false);
        frame.add(doorStatus);

        panel = new ImagePanel(new ImageIcon("docs/TMNSmartDoor.jpg").getImage());
        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }






    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        User user = new User(frame);
    }


}
