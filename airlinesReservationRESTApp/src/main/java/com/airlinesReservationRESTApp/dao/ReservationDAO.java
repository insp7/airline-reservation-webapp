package com.airlinesReservationRESTApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.airlinesReservationRESTApp.models.Reservation;

@Repository
public class ReservationDAO {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationDAO(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Long saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        System.out.println("Reservation Saved.");
        Long insertedID = reservationRepository.findLastInsertedRecord();
        System.out.println("Last inserted id = " + insertedID);
        return insertedID;
    }

    public List<Reservation> getReservations() {
        System.out.println("Coming here");
        Iterable<Reservation> iterable = reservationRepository.findAll();
        List<Reservation> reservations = new ArrayList<>();
        iterable.forEach(reservations::add);
        System.out.println(reservations.toString());
        return reservations;
    }

    public Reservation getReservation(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.isPresent() ? reservationOptional.get() : null;
    }

    public void updateReservation(Reservation updatedReservation) {
        if(reservationRepository.existsById(updatedReservation.getId())) {
        	reservationRepository.save(updatedReservation);
        } else {
            System.out.println("Trying to update a reservation which doesn't exist.");
        }
    }

    public void deleteReservation(Long id) {
    	reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsForUser(Long id) {
        return reservationRepository.getReservationsForUserId(id);
    }
}
