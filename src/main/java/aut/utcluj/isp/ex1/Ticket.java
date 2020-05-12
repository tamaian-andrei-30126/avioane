package aut.utcluj.isp.ex1;

/**
 * @author stefan
 */
public class   Ticket {
    private String id;
    private String customerName;
    private Double price;

    public Ticket(String customerName, Double price) {
        this.id = String.valueOf(Math.random());
        this.customerName = customerName;
        this.price = price;
    }

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
