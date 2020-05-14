package aut.utcluj.isp.ex4;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

public class Interfata extends JFrame {
    private final AirplaneTicketController atc;
    private JFrame mainFrame;
    private JButton getTicketsB, getTicketDetailsB, buyTicketB, cancelTicketB, changeTicketCustomerIdB, filterTicketsByStatusB, groupTicketsByCustomerIdB;

    private JFrame getTicketsFrame, getTicketDetailsFrame;
    private JButton enterB1;
    private JTextField ticketIdTF1;

    private JFrame buyTicketFrame;
    private JButton enterB2;
    private JTextField destinationTF1, customerIdTF1;

    public Interfata(AirplaneTicketController atc) throws HeadlessException {
        this.atc = atc;
        this.mainFrameInitialize();
        this.FrameHandlers();
        this.getTicketsBFrame();
        this.getTicketDetailsBFrame();
        this.buyTicketBFrame();
    }

    private void mainFrameInitialize() {
        this.mainFrame = new JFrame();
        this.mainFrame.setLayout(new GridLayout(4, 2));

        this.getTicketsB = new JButton("Get Tickets");
        this.mainFrame.add(getTicketsB);

        this.getTicketDetailsB = new JButton("Get ticket details");
        this.mainFrame.add(getTicketDetailsB);

        this.buyTicketB = new JButton("Buy ticket");
        this.mainFrame.add(buyTicketB);

        this.cancelTicketB = new JButton("Cancel ticket");
        this.mainFrame.add(cancelTicketB);

        this.changeTicketCustomerIdB = new JButton("Change ticket customere id");
        this.mainFrame.add(changeTicketCustomerIdB);

        this.filterTicketsByStatusB = new JButton("Filter tickets by status");
        this.mainFrame.add(filterTicketsByStatusB);

        this.groupTicketsByCustomerIdB = new JButton("Group tickets by customer id");
        this.mainFrame.add(groupTicketsByCustomerIdB);
        ;

        this.mainFrame.pack();
        this.mainFrame.setIconImage(new ImageIcon("docs/airplane.png").getImage());
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainFrame.setLocationRelativeTo(null);
        this.mainFrame.setVisible(true);
    }

    public void getTicketsBFrame() {
        this.getTicketsFrame = new JFrame();
        this.getTicketsFrame.setLayout(new GridLayout(5, 2));
        this.getTicketsFrame.setVisible(false);

        this.getTicketsFrame.setSize(500, 500);
        this.getTicketsFrame.setIconImage(new ImageIcon("docs/airplane.png").getImage());
        this.getTicketsFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.getTicketsFrame.setLocationRelativeTo(null);
    }

    public void getTicketDetailsBFrame() {
        this.getTicketDetailsFrame = new JFrame();
        this.getTicketDetailsFrame.setLayout(new GridLayout(2, 2));

        this.getTicketDetailsFrame.setVisible(false);
        this.getTicketDetailsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.getTicketDetailsFrame.setIconImage(new ImageIcon("docs/airplane.png").getImage());
        this.getTicketDetailsFrame.setLocationRelativeTo(null);

        final JLabel enterTicketIdLabel = new JLabel("Enter the ID of the ticket");
        enterTicketIdLabel.setBounds(10, 5, 150, 30);
        enterTicketIdLabel.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.getTicketDetailsFrame.add(enterTicketIdLabel);

        this.ticketIdTF1 = new JTextField("****");
        this.ticketIdTF1.setBounds(165, 5, 150, 30);
        this.ticketIdTF1.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.getTicketDetailsFrame.add(ticketIdTF1);


        this.enterB1 = new JButton("Enter");
        this.enterB1.setBounds(100, 20, 30, 30);
        this.enterB1.setFont(new Font("Cooper Black", Font.BOLD, 15));
        this.getTicketDetailsFrame.add(enterB1);

        this.getTicketDetailsFrame.pack();
    }

    public void buyTicketBFrame() {
        this.buyTicketFrame = new JFrame();
        this.buyTicketFrame.setLayout(new GridLayout(3, 2));

        this.buyTicketFrame.setVisible(false);
        this.buyTicketFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.buyTicketFrame.setIconImage(new ImageIcon("docs/airplane.png").getImage());
        this.buyTicketFrame.setLocationRelativeTo(null);

        final JLabel destinationLabel = new JLabel("Enter the destination");
        destinationLabel.setBounds(10, 5, 150, 30);
        destinationLabel.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.buyTicketFrame.add(destinationLabel);

        this.destinationTF1 = new JTextField("");
        this.destinationTF1.setBounds(165, 5, 150, 30);
        this.destinationTF1.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.buyTicketFrame.add(destinationTF1);

        final JLabel customerIdLabel = new JLabel("Enter the customer ID");
        customerIdLabel.setBounds(10, 5, 150, 30);
        customerIdLabel.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.buyTicketFrame.add(customerIdLabel);

        this.customerIdTF1 = new JTextField("");
        this.customerIdTF1.setBounds(165, 5, 150, 30);
        this.customerIdTF1.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.buyTicketFrame.add(customerIdTF1);


        this.enterB2 = new JButton("Enter");
        this.enterB2.setBounds(100, 20, 30, 30);
        this.enterB2.setFont(new Font("Cooper Black", Font.BOLD, 15));
        this.buyTicketFrame.add(enterB2);

        this.buyTicketFrame.pack();
    }


    private void FrameHandlers() {
        this.getTicketsB.addActionListener(gettickets -> {
            getTicketsFrame.setVisible(true);
            //JOptionPane.showMessageDialog(null, "Ticket bought succesfully", JOptionPane.OK_OPTION);


        });
        this.getTicketDetailsB.addActionListener(getticketdetails -> {

            getTicketDetailsFrame.setVisible(true);
        });
        this.buyTicketB.addActionListener(buyticket -> {
            buyTicketFrame.setVisible(true);
            this.enterB2.addActionListener(enterb2 -> {
                try {
                    atc.buyTicket(this.destinationTF1.getText(), this.customerIdTF1.getText());
                    buyTicketFrame.setVisible(false);
                    //JOptionPane.showMessageDialog(buyTicketFrame, "Ticket bought succesfully", JOptionPane.INFORMATION_MESSAGE);
                } catch (NoTicketAvailableException e) {
                    // JOptionPane.showMessageDialog(buyTicketFrame, "All tickets are sold for destination "+this.destinationTF1.getText(),JOptionPane.ERROR_MESSAGE);
                    buyTicketFrame.setVisible(true);
                    e.printStackTrace();
                } catch(NoDestinationAvailableException e){
                    //JOptionPane.showMessageDialog(buyTicketFrame, "This destination is not available",JOptionPane.ERROR_MESSAGE);
                    buyTicketFrame.setVisible(true);
                    e.printStackTrace();
                }
            });
        });

        this.cancelTicketB.addActionListener(cancelticket -> {

        });
        this.changeTicketCustomerIdB.addActionListener(changeticketcustomerid -> {

        });

        this.filterTicketsByStatusB.addActionListener(filterticket -> {

        });
        this.groupTicketsByCustomerIdB.addActionListener(groupticket -> {

        });

    }
}
