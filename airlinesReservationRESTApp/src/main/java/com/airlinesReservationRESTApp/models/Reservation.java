package com.airlinesReservationRESTApp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservations")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long userId;
	private Long flightId;
	private Integer cabinClass;
	private Integer isCancelled;
	private Integer totalFare;
	private Integer returnedAmount;
	private String createdAt;
	
	public Reservation() { }

	public Reservation(Long id, Long userId, Long flightId, Integer cabinClass, Integer isCancelled, Integer totalFare, Integer returnedAmount, String createdAt) {
		this.id = id;
		this.userId = userId;
		this.flightId = flightId;
		this.cabinClass = cabinClass;
		this.isCancelled = isCancelled;
		this.totalFare = totalFare;
		this.returnedAmount = returnedAmount;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public Integer getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(Integer cabinClass) {
		this.cabinClass = cabinClass;
	}

	public Integer getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Integer isCancelled) {
		this.isCancelled = isCancelled;
	}

	public Integer getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Integer totalFare) {
		this.totalFare = totalFare;
	}

	public Integer getReturnedAmount() {
		return returnedAmount;
	}

	public void setReturnedAmount(Integer returnedAmount) {
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

		Reservation that = (Reservation) o;

		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"id=" + id +
				", userId=" + userId +
				", flightId=" + flightId +
				", cabinClass='" + cabinClass + '\'' +
				", isCancelled=" + isCancelled +
				", totalFare=" + totalFare +
				", returnedAmount=" + returnedAmount +
				", createdAt='" + createdAt + '\'' +
				'}';
	}
}
