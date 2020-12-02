package com.rashmi.entity;

import org.joda.time.DateTime;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long flight_no;
    private long source;
    private long destination;
    private DateTime departure_date;
    private DateTime arrival_date;
    private long capacity;
    private long cabin_class;
    private long fare;
    private boolean is_deleted;
    
    public Flight() { }

	public Flight(long flight_no, long source, long destination, DateTime departure_date, DateTime arrival_date,
			long capacity, long cabin_class, long fare, boolean is_deleted) {
		super();
		this.flight_no = flight_no;
		this.source = source;
		this.destination = destination;
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
		this.capacity = capacity;
		this.cabin_class = cabin_class;
		this.fare = fare;
		this.is_deleted = is_deleted;
	}

	public long getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(long flight_no) {
		this.flight_no = flight_no;
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

	public DateTime getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(DateTime departure_date) {
		this.departure_date = departure_date;
	}

	public DateTime getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(DateTime arrival_date) {
		this.arrival_date = arrival_date;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public long getCabin_class() {
		return cabin_class;
	}

	public void setCabin_class(long cabin_class) {
		this.cabin_class = cabin_class;
	}

	public long getFare() {
		return fare;
	}

	public void setFare(long fare) {
		this.fare = fare;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Flight flight = (Flight) o;

	        return flight_no == flight.flight_no;
	    }

	    @Override
	    public int hashCode() {
	        return (int) (flight_no ^ (flight_no >>> 32));
	    }

		@Override
		public String toString() {
			return "Flight [flight_no=" + flight_no + ", source=" + source + ", destination=" + destination
					+ ", departure_date=" + departure_date + ", arrival_date=" + arrival_date + ", capacity=" + capacity
					+ ", cabin_class=" + cabin_class + ", fare=" + fare + ", is_deleted=" + is_deleted + "]";
		}
	
	    
	
}
