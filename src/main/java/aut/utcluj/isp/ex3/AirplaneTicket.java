package aut.utcluj.isp.ex3;

import java.util.Objects;

/**
 * @author stefan
 */
public class AirplaneTicket {
    private String id;
    private Double price;
    private String destination;

    public void setDestination(String destination) {
        this.destination = destination;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirplaneTicket that = (AirplaneTicket) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(price, that.price) &&
                Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, destination);
    }
}
