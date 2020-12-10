package com.airlinesReservationRESTApp.dao;

import com.airlinesReservationRESTApp.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PassengerDAO {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerDAO(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger getPassenger(Long id) {
        Optional<Passenger> passengerOptional = passengerRepository.findById(id);
        return passengerOptional.isPresent() ? passengerOptional.get() : null;
    }

    public void savePassenger(Passenger passenger) {
        if(passengerRepository.existsById(passenger.getId()))
            System.out.println("Passenger Already Exists.");
        else {
            passengerRepository.save(passenger);
            System.out.println("Passenger Saved.");
        }
    }

    public List<Passenger> getPassengers() {
        Iterable<Passenger> iterable = passengerRepository.findAll();
        List<Passenger> passengers = new ArrayList<>();
        iterable.forEach(passengers::add);

        return passengers;
    }

    public void updatePassenger(Passenger updatedPassenger) {
        if(passengerRepository.existsById(updatedPassenger.getId())) {
            passengerRepository.save(updatedPassenger);
        } else {
            System.out.println("Trying to update a user which doesn't exist.");
        }
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
