package aut.utcluj.isp.ex4;

import java.awt.*;
import javax.swing.*;

public class ViewAndrei {
    // View uses Swing framework to display UI to user
    private JFrame frame;
    private ImagePanel panel = null;




    //private JLabel showTicketsLabel;
    //private JLabel lastnameLabel;
    //private JTextField firstnameTextfield;
    //private JTextField lastnameTextfield;
    private JButton showTicketsButton;
    private JButton exemplu;
    //private JButton hello;
    //private JButton bye;
    public ViewAndrei(String title) {


        frame = new JFrame(title);
        panel = new ImagePanel(new ImageIcon("docs/Ro's Airport.jpg").getImage());
        frame.getContentPane().add(panel);
        //`frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.setSize(1050, 600);
        //frame.setLocationRelativeTo(null);

        // Create UI elements
        //showTicketsLabel = new JLabel("Firstname :");
        showTicketsButton = new JButton("Show tickets");
        showTicketsButton.setBounds(20, 20, 400, 70);
        //  showTicketsButton.setFont(new Font("Dialog", Font.PLAIN, 30));

        frame.add(showTicketsButton);

        exemplu = new JButton("Exemplu");
        exemplu.setBounds(500, 270, 400, 70);
        frame.add(exemplu);
        //hello = new JButton("Hello!");
        //bye = new JButton("Bye!");

/*
        // Add UI element to frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

 */
        /*
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstnameLabel)
                        .addComponent(lastnameLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstnameTextfield)
                        .addComponent(lastnameTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstnameSaveButton)
                        .addComponent(lastnameSaveButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(hello)
                        .addComponent(bye)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(firstnameLabel)
                        .addComponent(firstnameTextfield).addComponent(firstnameSaveButton).addComponent(hello))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lastnameLabel)
                        .addComponent(lastnameTextfield).addComponent(lastnameSaveButton).addComponent(bye)));
        layout.linkSize(SwingConstants.HORIZONTAL, firstnameSaveButton, lastnameSaveButton);
        layout.linkSize(SwingConstants.HORIZONTAL, hello, bye);
        frame.getContentPane().setLayout(layout);
         */
    }

    public JFrame getFrame() {
        return frame;
    }

    public ImagePanel getPanel() {
        return panel;
    }

    public JButton getShowTicketsButton() {
        return showTicketsButton;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setPanel(ImagePanel panel) {
        this.panel = panel;
    }

    public void setShowTicketsButton(JButton showTicketsButton) {
        this.showTicketsButton = showTicketsButton;
    }

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

    }
}
