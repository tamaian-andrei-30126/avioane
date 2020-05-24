package aut.utcluj.isp.ex4;

import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.*;

public class Interfata extends JFrame {
    private final AirplaneTicketController atc;
    JScrollPane scrollpane;
    private JFrame mainFrame;
    private JButton getTicketsB, getTicketDetailsB, buyTicketB, cancelTicketB, changeTicketCustomerIdB, filterTicketsByStatusB, groupTicketsByCustomerIdB;

    private JFrame getTicketsFrame, getTicketDetailsFrame;
    private JButton enterB1;
    private JTextField ticketIdTF1;

    private JFrame buyTicketFrame;
    private JButton enterB2;
    private JTextField destinationTF1, customerIdTF1;

    private JFrame cancelTicketFrame;
    private JButton enterB3;
    private JTextField ticketIdTF2, customerIdTF2;

    private JFrame changeTicketCustomerIdFrame;
    private JButton enterB4;
    private JTextField ticketIdTF3;

    private JList jlist;
    private List<AirplaneTicket> tickets;

    private JFrame groupTicketsByCustomerIdFrame;
    private Map<String, List<AirplaneTicket>> grouptickets;

    private JFrame filterTicketsByStatusFrame;
    private List<AirplaneTicket> filterTickets;
    private JButton enterB5;
    private JTextField statusTicketTF1;


    public Interfata(AirplaneTicketController atc) throws HeadlessException {
        this.atc = atc;
        this.mainFrameInitialize();
        this.FrameHandlers();
        this.getTicketDetailsBFrame();
        this.buyTicketBFrame();
        this.cancelTicketBFrame();
        this.changeTicketCustomerIdBFrame();
        this.filterTicketsByStatusBFrame();
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

        this.changeTicketCustomerIdB = new JButton("Change ticket's customer id");
        this.mainFrame.add(changeTicketCustomerIdB);

        this.filterTicketsByStatusB = new JButton("Filter tickets by status");
        this.mainFrame.add(filterTicketsByStatusB);

        this.groupTicketsByCustomerIdB = new JButton("Group tickets by customer id");
        this.mainFrame.add(groupTicketsByCustomerIdB);

        this.mainFrame.pack();
        this.mainFrame.setIconImage(new ImageIcon("docs/airplane.png").getImage());
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainFrame.setLocationRelativeTo(null);
        this.mainFrame.setVisible(true);
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

        this.ticketIdTF1 = new JTextField("");
        this.ticketIdTF1.setBounds(165, 5, 150, 30);
        this.ticketIdTF1.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.getTicketDetailsFrame.add(ticketIdTF1);


        this.enterB1 = new JButton("Enter");
        this.enterB1.setBounds(100, 20, 30, 30);
        this.enterB1.setFont(new Font("Cooper Black", Font.BOLD, 15));
        this.getTicketDetailsFrame.add(enterB1);

        this.getTicketDetailsFrame.pack();
    }

    public void cancelTicketBFrame() {
        this.cancelTicketFrame = new JFrame();
        this.cancelTicketFrame.setLayout(new GridLayout(2, 2));

        this.cancelTicketFrame.setVisible(false);
        this.cancelTicketFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.cancelTicketFrame.setIconImage(new ImageIcon("docs/airplane.png").getImage());
        this.cancelTicketFrame.setLocationRelativeTo(null);

        final JLabel ticketIdLabel = new JLabel("Enter the ID of the ticket");
        ticketIdLabel.setBounds(10, 5, 150, 30);
        this.cancelTicketFrame.add(ticketIdLabel);

        this.ticketIdTF2 = new JTextField("");
        this.ticketIdTF2.setBounds(165, 5, 150, 30);
        this.ticketIdTF2.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.cancelTicketFrame.add(ticketIdTF2);

        this.enterB3 = new JButton("Enter");
        this.enterB3.setBounds(100, 20, 30, 30);
        this.enterB3.setFont(new Font("Cooper Black", Font.BOLD, 15));
        this.cancelTicketFrame.add(enterB3);

        this.cancelTicketFrame.pack();
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

    public void changeTicketCustomerIdBFrame() {
        this.changeTicketCustomerIdFrame = new JFrame();
        this.changeTicketCustomerIdFrame.setLayout(new GridLayout(3, 2));

        this.changeTicketCustomerIdFrame.setVisible(false);
        this.changeTicketCustomerIdFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.changeTicketCustomerIdFrame.setIconImage(new ImageIcon("docs/airplane.png").getImage());
        this.changeTicketCustomerIdFrame.setLocationRelativeTo(null);

        final JLabel ticketLabel = new JLabel("Enter the ID of the ticket");
        ticketLabel.setBounds(10, 5, 150, 30);
        ticketLabel.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.changeTicketCustomerIdFrame.add(ticketLabel);

        this.ticketIdTF3 = new JTextField("");
        this.ticketIdTF3.setBounds(165, 5, 150, 30);
        this.ticketIdTF3.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.changeTicketCustomerIdFrame.add(ticketIdTF3);

        final JLabel customerIdLabel = new JLabel("Enter the new customer ID");
        customerIdLabel.setBounds(10, 5, 150, 30);
        customerIdLabel.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.changeTicketCustomerIdFrame.add(customerIdLabel);

        this.customerIdTF2 = new JTextField("");
        this.customerIdTF2.setBounds(165, 5, 150, 30);
        this.customerIdTF2.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.changeTicketCustomerIdFrame.add(customerIdTF2);


        this.enterB4 = new JButton("Enter");
        this.enterB4.setBounds(100, 20, 30, 30);
        this.enterB4.setFont(new Font("Cooper Black", Font.BOLD, 15));
        this.changeTicketCustomerIdFrame.add(enterB4);

        this.changeTicketCustomerIdFrame.pack();
    }

    public void filterTicketsByStatusBFrame() {
        this.filterTicketsByStatusFrame = new JFrame();
        this.filterTicketsByStatusFrame.setLayout(new GridLayout(2, 2));

        this.filterTicketsByStatusFrame.setVisible(false);
        this.filterTicketsByStatusFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.filterTicketsByStatusFrame.setIconImage(new ImageIcon("docs/airplane.png").getImage());
        this.filterTicketsByStatusFrame.setLocationRelativeTo(null);

        final JLabel enterStatusTicketLabel = new JLabel("Enter the status of the ticket");
        enterStatusTicketLabel.setBounds(10, 5, 150, 30);
        enterStatusTicketLabel.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.filterTicketsByStatusFrame.add(enterStatusTicketLabel);

        this.statusTicketTF1 = new JTextField("");
        this.statusTicketTF1.setBounds(165, 5, 150, 30);
        this.statusTicketTF1.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        this.filterTicketsByStatusFrame.add(this.statusTicketTF1);


        this.enterB5 = new JButton("Enter");
        this.enterB5.setBounds(100, 20, 30, 30);
        this.enterB5.setFont(new Font("Cooper Black", Font.BOLD, 15));
        this.filterTicketsByStatusFrame.add(this.enterB5);

        this.filterTicketsByStatusFrame.pack();
    }

    private void FrameHandlers() {
        this.getTicketsB.addActionListener(gettickets -> {
            this.getTicketsFrame = new JFrame();
            this.getTicketsFrame.setLayout(new GridLayout(2, 1));
            this.getTicketsFrame.setVisible(true);
            tickets = new ArrayList<>();
            tickets = atc.getTickets();
            String[] data = new String[tickets.size()];
            for (int i = 0; i < tickets.size(); i++) {
                data[i] = tickets.get(i).toString();
            }
            jlist = new JList(data);
            JScrollPane jScrollPane = new JScrollPane(jlist);
            this.getTicketsFrame.add(jScrollPane);

            JButton exitButton = new JButton("Exit");
            this.getTicketsFrame.add(exitButton);

            this.getTicketsFrame.setSize(500, 500);
            this.getTicketsFrame.setIconImage(new ImageIcon("docs/airplane.png").getImage());
            this.getTicketsFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            this.getTicketsFrame.setLocationRelativeTo(null);
            this.getTicketsFrame.pack();
            exitButton.addActionListener(exitbutton -> {
                this.getTicketsFrame.setVisible(false);
            });

        });
        this.getTicketDetailsB.addActionListener(getticketdetails -> {

            getTicketDetailsFrame.setVisible(true);
            this.enterB1.addActionListener(enterb1 -> {
                try {
                    //int i;
                    JFrame enter = new JFrame();
                    enter.setLayout(new GridLayout(2, 1));
                    enter.setVisible(true);
                    tickets = new ArrayList<>();
                    tickets = Collections.singletonList(atc.getTicketDetails(this.ticketIdTF1.getText()));
                    //tickets = atc.getTickets();
                    String[] data = new String[tickets.size()];
                    /*for (i = 0; i < tickets.size(); i++) {
                        if (tickets.get(i).getId().equals(this.ticketIdTF1.getText())) {
                            break;
                        }
                    }
                    data[0] = tickets.get(i).toString();*/
                    for (int i = 0; i < tickets.size(); i++) {
                        data[i] = tickets.get(i).toString();
                    }
                    jlist = new JList(data);
                    scrollpane = new JScrollPane(jlist);
                    enter.add(scrollpane);

                    JButton exitButton = new JButton("Exit");
                    enter.add(exitButton);

                    enter.setSize(500, 500);
                    enter.setIconImage(new ImageIcon("docs/airplane.png").getImage());
                    enter.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                    enter.setLocationRelativeTo(null);
                    enter.pack();
                    exitButton.addActionListener(exitbutton -> {
                        enter.setVisible(false);
                    });
                } catch (NoTicketAvailableException e) {
                    JOptionPane.showMessageDialog(buyTicketFrame, "Ticket id not found", "", JOptionPane.WARNING_MESSAGE);
                    e.printStackTrace();
                }
            });
            this.ticketIdTF1.setText("");
        });
        this.buyTicketB.addActionListener(buyticket -> {
            buyTicketFrame.setVisible(true);
            this.enterB2.addActionListener(enterb2 -> {
                try {
                    atc.buyTicket(this.destinationTF1.getText(), this.customerIdTF1.getText());
                    JOptionPane.showMessageDialog(null, "Ticket bought succesfully", "", JOptionPane.INFORMATION_MESSAGE);
                } catch (NoTicketAvailableException e) {
                    JOptionPane.showMessageDialog(buyTicketFrame, "All tickets are sold for destination " + this.destinationTF1.getText(), "", JOptionPane.WARNING_MESSAGE);
                    e.printStackTrace();
                } catch (NoDestinationAvailableException e) {
                    JOptionPane.showMessageDialog(buyTicketFrame, "This destination is not available", "", JOptionPane.WARNING_MESSAGE);
                    e.printStackTrace();
                }
                this.destinationTF1.setText("");
                this.customerIdTF1.setText("");
            });
        });

        this.cancelTicketB.addActionListener(cancelticket -> {
            cancelTicketFrame.setVisible(true);
            this.enterB3.addActionListener(enterb3 -> {
                try {
                    atc.cancelTicket(this.ticketIdTF2.getText());
                    JOptionPane.showMessageDialog(null, "Ticket cancelled succesfully", "", JOptionPane.INFORMATION_MESSAGE);
                } catch (NoTicketAvailableException e) {
                    JOptionPane.showMessageDialog(buyTicketFrame, "Ticket with this ID doesn't exist!", "", JOptionPane.WARNING_MESSAGE);
                    e.printStackTrace();
                } catch (TicketNotAssignedException e) {
                    JOptionPane.showMessageDialog(buyTicketFrame, "Ticket can't be cancelled because it is not Active!", "", JOptionPane.WARNING_MESSAGE);
                    e.printStackTrace();
                }
                this.ticketIdTF2.setText("");
            });
        });
        this.changeTicketCustomerIdB.addActionListener(changeticketcustomerid -> {
            changeTicketCustomerIdFrame.setVisible(true);
            this.enterB4.addActionListener(enterb4 -> {
                try {
                    atc.changeTicketCustomerId(this.ticketIdTF3.getText(), this.customerIdTF2.getText());
                    JOptionPane.showMessageDialog(null, "Customer ID changed succesfully", "", JOptionPane.INFORMATION_MESSAGE);
                } catch (NoTicketAvailableException e) {
                    JOptionPane.showMessageDialog(buyTicketFrame, "Ticket with this ID doesn't exist!", "", JOptionPane.WARNING_MESSAGE);
                    e.printStackTrace();
                } catch (TicketNotAssignedException e) {
                    JOptionPane.showMessageDialog(buyTicketFrame, "Ticket can't be cancelled because it is not Active!", "", JOptionPane.WARNING_MESSAGE);
                    e.printStackTrace();
                }
                this.ticketIdTF2.setText("");
            });
        });

        this.filterTicketsByStatusB.addActionListener(filterticket -> {
            filterTicketsByStatusFrame.setVisible(true);
            this.enterB5.addActionListener(enterb5 -> {
                int i;
                JFrame enter = new JFrame();
                enter.setLayout(new GridLayout(2, 1));
                enter.setVisible(true);
                filterTickets = new ArrayList<>();
             //   filterTickets = Collections.singletonList(atc.filterTicketsByStatus(this.statusTicketTF1.getText()));
                String[] data = new String[filterTickets.size()];
                for (i = 0; i < filterTickets.size(); i++) {
                    if (filterTickets.get(i).getStatus().equals(this.ticketIdTF1.getText())) {
                        data[i] = filterTickets.get(i).toString();
                    }
                }
                jlist = new JList(data);
                scrollpane = new JScrollPane(jlist);
                enter.add(scrollpane);

                JButton exitButton = new JButton("Exit");
                enter.add(exitButton);

                enter.setSize(500, 500);
                enter.setIconImage(new ImageIcon("docs/airplane.png").getImage());
                enter.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                enter.setLocationRelativeTo(null);
                enter.pack();
                exitButton.addActionListener(exitbutton -> {
                    enter.setVisible(false);
                });
            });
            this.statusTicketTF1.setText("");

        });
        this.groupTicketsByCustomerIdB.addActionListener(groupticket -> {
  /*          this.groupTicketsByCustomerIdFrame = new JFrame();
            this.groupTicketsByCustomerIdFrame.setLayout(new GridLayout(2, 1));
            this.groupTicketsByCustomerIdFrame.setVisible(true);*/
            grouptickets = new HashMap<>();
            grouptickets = atc.groupTicketsByCustomerId();
            String[] data = new String[grouptickets.size()];
            for (int i = 0; i < grouptickets.size(); i++) {
                data[i] = grouptickets.get(i).toString();
            }
            jlist = new JList(data);
            JScrollPane jScrollPane = new JScrollPane(jlist);
            this.groupTicketsByCustomerIdFrame.add(jScrollPane);

            JButton exitButton = new JButton("Exit");
            this.groupTicketsByCustomerIdFrame.add(exitButton);

            this.groupTicketsByCustomerIdFrame.setSize(500, 500);
            this.groupTicketsByCustomerIdFrame.setIconImage(new ImageIcon("docs/airplane.png").getImage());
            this.groupTicketsByCustomerIdFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            this.groupTicketsByCustomerIdFrame.setLocationRelativeTo(null);
            this.groupTicketsByCustomerIdFrame.pack();
            exitButton.addActionListener(exitbutton -> {
                this.groupTicketsByCustomerIdFrame.setVisible(false);
            });

        });

    }
}
