package aut.utcluj.isp.ex2;

import aut.utcluj.isp.ex4.NoTicketAvailableException;

/**
 * @author stefan
 */
public class Ticket extends NoTicketAvailableException {
    private String id;
    private String customerName;
    private Double price;

    public Ticket(String id, String customerName, Double price) {
        this.id = id;
        this.customerName = customerName;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getPrice() {
        return price;
    }
}
