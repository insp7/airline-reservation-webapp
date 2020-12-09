package com.airlinesReservationRESTApp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

// CREATE TABLE passengers(id NUMBER(11) PRIMARY KEY, reservationID NUMBER(11), seatNo NUMBER(11), firstName VARCHAR2(64), lastName VARCHAR2(64), gender VARCHAR2(1), dateOfBirth VARCHAR2(30), passengerType VARCHAR2(1));

@Entity
@Table(name = "passengers")
public class Passenger implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private Long reservationID;
    private Long seatNo;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String passengerType; // I => Infant, C => Child, A => Adult

    public Passenger() { }

    public Passenger(Long id, Long reservationID, Long seatNo, String firstName, String lastName, String gender, String dateOfBirth, String passengerType) {
        this.id = id;
        this.reservationID = reservationID;
        this.seatNo = seatNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.passengerType = passengerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservationID() {
        return reservationID;
    }

    public void setReservationID(Long reservationID) {
        this.reservationID = reservationID;
    }

    public Long getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Long seatNo) {
        this.seatNo = seatNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        return id.equals(passenger.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", reservationID=" + reservationID +
                ", seatNo=" + seatNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", passengerType='" + passengerType + '\'' +
                '}';
    }
}
