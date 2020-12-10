package com.airlinesReservationRESTApp.models;

public class FlightPreference {
    private long source;
    private long destination;
    private String departureDate;
    private String returnDate;
    private String passengersCount;

    public FlightPreference() { }

    public FlightPreference(long source, long destination, String departureDate, String returnDate, String passengersCount) {
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengersCount = passengersCount;
    }

    public long getSource() {
        return source;
    }

    public long getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getPassengersCount() {
        return passengersCount;
    }
}
