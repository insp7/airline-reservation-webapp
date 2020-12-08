package com.airlinesReservationRESTApp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private long source;
    private long destination;
    private String departureDate;
    private String arrivalDate;
    private int capacity;
    private int cabinClass;
    private int fare;

    Flight() { }

    public Flight(long id, long source, long destination, String departureDate, String arrivalDate, int capacity, int cabinClass, int fare) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.capacity = capacity;
        this.cabinClass = cabinClass;
        this.fare = fare;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSource() {
        return source;
    }

    public void setSource(long source) {
        this.source = source;
    }

    public long getDestination() {
        return destination;
    }

    public void setDestination(long destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(int cabinClass) {
        this.cabinClass = cabinClass;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        return id == flight.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", source=" + source +
                ", destination=" + destination +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", capacity=" + capacity +
                ", cabinClass=" + cabinClass +
                ", fare=" + fare +
                '}';
    }
}
