package aut.utcluj.isp.ex4;


import com.sun.deploy.security.SelectableSecurityManager;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author stefan
 */
public class AirplaneTicketController {
    /**
     * Default number of tickets when a new instance is created
     */
    public static final int DEFAULT_NUMBER_OF_TICKETS = 10;
    private List<AirplaneTicket> tickets;

    /**
     * Generate default tickets
     */

    public AirplaneTicketController() {
        tickets = new ArrayList<>();
        generateTickets();
    }

    private void generateTickets() {
        for (int i = 0; i < DEFAULT_NUMBER_OF_TICKETS; i++) {
            String destination;
            Double price;

            if (i < 3) {
                destination = "Cluj-Napoca";
                price = 10d;
            } else if (i < 6) {
                destination = "Baia Mare";
                price = 20d;
            } else {
                destination = "Timisoara";
                price = 15d;
            }

            final AirplaneTicket airplaneTicket = new AirplaneTicket("ID-" + i, price, destination);
            airplaneTicket.setStatus(TicketStatus.NEW);

            tickets.add(airplaneTicket);
        }
    }

    public List<AirplaneTicket> getTickets() {
        return tickets;
    }

    /**
     * Get ticket details by ticket id
     *
     * @param ticketId - unique ticket id
     * @return
     * @apiNote: this method should throw {@link NoTicketAvailableException} exception if ticket not found
     */
    public AirplaneTicket getTicketDetails(final String ticketId) throws NoTicketAvailableException {

        AirplaneTicket airplaneTicket = new AirplaneTicket(ticketId, null, null);
        int i = 0;
        for (i = 0; i < tickets.size(); i++)
            if (airplaneTicket.getId().equals(tickets.get(i).getId())) {
                return tickets.get(i);
            }
        if (i == tickets.size()) {
            throw new NoTicketAvailableException("No ticket id");
        }
        return airplaneTicket;
    }

    /**
     * Buy ticket with specific destination
     * Ticket information should be updated: customer name and status {@link TicketStatus#ACTIVE}
     *
     * @param destination - destination
     * @param customerId  - customer name
     * @return
     * @apiNote: this method should throw the following exceptions:
     * {@link NoDestinationAvailableException} - if destination not supported by AirplaneTicketController
     * {@link NoTicketAvailableException} - if destination exists but no ticket with NEW status available
     */
    public void buyTicket(final String destination, final String customerId) throws NoDestinationAvailableException, NoTicketAvailableException {
        int i;
        for (i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getStatus().equals(TicketStatus.NEW) && destination.equals(tickets.get(i).getDestination())) {
                tickets.get(i).setStatus(TicketStatus.ACTIVE);
                tickets.get(i).setCustomerId(customerId);
                System.out.println("Ticket Bought for destination " + destination);
                break;
            }
        }

        if ((i == tickets.size()) && ((destination.equals("Cluj-Napoca") || destination.equals("Baia Mare") || destination.equals("Timisoara")))) {
            throw new NoTicketAvailableException("All tickets sold out for destination " + destination);
        } else if (i == tickets.size() && (!destination.equals("Cluj-Napoca") && !destination.equals("Baia Mare") && !destination.equals("Timisoara"))) {
            throw new NoDestinationAvailableException("Destination Incorect!");
        }

    }

    /**
     * Cancel specific ticket
     * Status of the ticket should be set to {@link TicketStatus#CANCELED}
     *
     * @param ticketId - unique ticket id
     * @return
     * @apiNote: this method should throw the following exceptions:
     * {@link NoTicketAvailableException} - if ticket with this id does not exist
     * {@link TicketNotAssignedException} - if ticket is not assigned to any user
     */
    public void cancelTicket(final String ticketId) throws TicketNotAssignedException, NoTicketAvailableException {

        int i;
        boolean checkifticketexist = false;
        boolean ticketnotassigned = false;
        for (i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId().equals(ticketId) && tickets.get(i).getStatus().equals(TicketStatus.ACTIVE)) {
                tickets.get(i).setStatus(TicketStatus.CANCELED);
                checkifticketexist = true;
                System.out.println("Ticket is canceled!");
            }
        }

        if (checkifticketexist == false) {
            throw new NoTicketAvailableException("Ticket with this ID doesn't exist!");
        }

        for (i = 0; i < tickets.size(); i++)
            if (tickets.get(i).getStatus().equals(TicketStatus.NEW) && tickets.get(i).getId().equals(ticketId)) {
                ticketnotassigned = true;
            }
        if (ticketnotassigned == true) {
            throw new TicketNotAssignedException("Ticket can't be cancel because is not Active!");
        }


    }


    /**
     * Change ticket customer name by specific ticket id
     *
     * @param ticketId   - unique ticket id
     * @param customerId - unique customer name
     * @return
     * @apiNote: this method should throw the following exceptions:
     * {@link NoTicketAvailableException} - if ticket with this id does not exist
     * {@link TicketNotAssignedException} - if ticket is not assigned to any user
     */
    public void changeTicketCustomerId(final String ticketId, final String customerId) {
        int i;
        boolean ticketnotassigned = false;
        boolean checkifidexists = false;
        for (i = 0; i < tickets.size(); i++)
            if (tickets.get(i).getId().equals(ticketId)) {
                checkifidexists = true;
                System.out.println("CostumerId Changed!");
                tickets.get(i).setCustomerId(customerId);
                System.out.println("New CostumerId este:" + tickets.get(i).getCustomerId());
            }

        if (checkifidexists == false) {
            throw new NoTicketAvailableException("Ticket with this ID doesn't exist!");
        }
        for (i = 0; i < tickets.size(); i++)
            if (tickets.get(i).getStatus().equals(TicketStatus.NEW) && tickets.get(i).getId().equals(ticketId)) {
                ticketnotassigned = true;
            }
        if (ticketnotassigned == true) {
            throw new TicketNotAssignedException("Ticket costumerId can't be change because is not Active!");
        }


    }

    /**
     * This method should filter all tickets by provided status.
     * An empty list should be returned if no tickets available with desired status
     *
     * @param status - ticket status
     * @return
     */
    public List<AirplaneTicket> filterTicketsByStatus(final TicketStatus status) {
        List<AirplaneTicket> filtertickets = new ArrayList<>();
        int i;
        for (i = 0; i < tickets.size(); i++)
            if (tickets.get(i).getStatus().equals(status)) {
                filtertickets.add(tickets.get(i));
            }
        return filtertickets;
    }

    /**
     * Return the tickets grouped by customer id
     *
     * @return dictionary where the key is the customer name and the value is a list of tickets for that customer
     * @apiNote: only tickets with available name should be returned
     */
    public Map<String, List<AirplaneTicket>> groupTicketsByCustomerId() {
        Map<String, List<AirplaneTicket>> ticketbycostumername = new HashMap<>();
        int i;
        int j;
        String namex;
        List<AirplaneTicket> grouptickets;
        for (i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getStatus().equals(TicketStatus.ACTIVE)) {
                namex = tickets.get(i).getCustomerId();
                grouptickets = new ArrayList<>();
                for (j = 0; j < tickets.size(); j++) {
                    if (tickets.get(j).getCustomerId() != null && tickets.get(j).getCustomerId().equals(namex))
                        grouptickets.add(tickets.get(j));
                }

                if (!ticketbycostumername.containsKey(namex))
                    ticketbycostumername.put(namex, grouptickets);

            }

        }

        System.out.println(ticketbycostumername.keySet().size());
        return ticketbycostumername;


    }
}
