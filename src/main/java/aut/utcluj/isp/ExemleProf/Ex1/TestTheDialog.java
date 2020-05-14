package aut.utcluj.isp.ExemleProf.Ex1;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestTheDialog extends JFrame implements ActionListener {

    JButton myButton = null;

    public TestTheDialog() {
        setTitle("Test Dialog");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        myButton = new JButton("Test the dialog!");
        myButton.addActionListener(this);
        setLocationRelativeTo(null);
        add(myButton);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (myButton == e.getSource()) {
            System.err.println("Opening dialog.");
            CustomDialog myDialog = new CustomDialog(this, true, "Do you like Java?");
            System.err.println("After opening dialog.");
            if (myDialog.getAnswer()) {
                System.err.println("The answer stored in CustomDialog is 'true' (i.e. user clicked yes button.)");
            } else {
                System.err.println("The answer stored in CustomDialog is 'false' (i.e. user clicked no button.)");
            }
        }
    }

    public static void main(String argv[]) {
        TestTheDialog tester = new TestTheDialog();
    }
}