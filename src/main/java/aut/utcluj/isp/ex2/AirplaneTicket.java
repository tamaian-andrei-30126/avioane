package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */
public class AirplaneTicket {
    private String destination;
    private String id;
    private String customerName;
    private String destination;
    private Double price;

    public AirplaneTicket(String id, String customerName, Double price, String destination) {
        this.id = id;
        this.customerName = customerName;
        this.price = price;
        this.destination = destination;

    }

    public String getDestination() {
        return destination;
    }
}
