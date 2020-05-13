package aut.utcluj.isp.ex4;
//am modificat ce am vrut eu

import java.util.Objects;

/**
 * @author stefan
 */
public class AirplaneTicket {
    private String id;
    private Double price;
    private String destination;
    private String customerId;
    private TicketStatus status;

    public AirplaneTicket(String id, Double price, String destination) {

        this.id = id;
        this.price = price;
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public String getDestination() {
        return destination;
    }

    public String getCustomerId() {
        return customerId;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "AirplaneTicket{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", destination='" + destination + '\'' +
                ", customerId='" + customerId + '\'' +
                ", status=" + status +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirplaneTicket)) return false;
        AirplaneTicket that = (AirplaneTicket) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(price, that.price) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(customerId, that.customerId) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, destination, customerId, status);
    }
}
