package com.airlinesReservationRESTApp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservations")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private long userId;
	private long flightId;
	private String cabinClass;
	private int isCancelled;
	private int totalFare;
	private int returnedAmount;
	private String createdAt;
	
	Reservation() {}
	
	public Reservation(long id, long userId, long flightId, String cabinClass, int isCancelled, int totalFare, int returnedAmount, String createdAt) {
		this.id = id;
		this.userId = userId;
		this.flightId = flightId;
		this.cabinClass = cabinClass;
		this.isCancelled = isCancelled;
		this.totalFare = totalFare;
		this.returnedAmount = returnedAmount;
		this.createdAt = createdAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}

	public int getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(int isCancelled) {
		this.isCancelled = isCancelled;
	}

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}
	
	 public int getReturnedAmount() {
		return returnedAmount;
	}

	public void setReturnedAmount(int returnedAmount) {
		this.returnedAmount = returnedAmount;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Reservation reservation = (Reservation) o;

	        return id == reservation.id;
	    }
	
	@Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
	
	 @Override
	    public String toString() {
	        return "Reservation{" +
	                "id=" + id +
	                ", user_id=" + userId +
	                ", flight_id=" + flightId +
	                ", cabin_class='" + cabinClass + '\'' +
	                ", total_fare='" + totalFare + '\'' +
	                ", is_cancelled=" + isCancelled +
	                '}';
	    }	
	
}
