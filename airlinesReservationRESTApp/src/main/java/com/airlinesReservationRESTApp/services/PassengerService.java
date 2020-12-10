package com.airlinesReservationRESTApp.services;

import com.airlinesReservationRESTApp.dao.PassengerDAO;
import com.airlinesReservationRESTApp.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private final PassengerDAO passengerDAO;

    @Autowired
    public PassengerService(PassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;
    }

    public List<Passenger> getPassengers() {
        return passengerDAO.getPassengers();
    }

    public Passenger getPassenger(Long id) {
        return passengerDAO.getPassenger(id);
    }

    public void addPassenger(Passenger passenger) {
        passengerDAO.savePassenger(passenger);
    }

    public void updatePassenger(Passenger updatedPassenger) {
        passengerDAO.updatePassenger(updatedPassenger);
    }

    public void deletePassenger(Long id) {
        passengerDAO.deletePassenger(id);
    }
}
