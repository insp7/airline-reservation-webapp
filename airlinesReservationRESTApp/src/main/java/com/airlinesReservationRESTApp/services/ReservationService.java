package com.airlinesReservationRESTApp.services;

import java.util.List;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlinesReservationRESTApp.dao.ReservationDAO;
import com.airlinesReservationRESTApp.models.Reservation;

@Service
public class ReservationService {
    private final ReservationDAO reservationDAO;

    @Autowired
    public ReservationService(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

	public String addReservation(Reservation reservation) {
		Long reservationId = reservationDAO.saveReservation(reservation);
		return new Gson().toJson(reservationId);
    }

    public List<Reservation> getReservations() {
        return reservationDAO.getReservations();
    }

    public Reservation getReservation(Long id) {
        return reservationDAO.getReservation(id);
    }

    public void updateReservation(Reservation updatedReservation) {
    	reservationDAO.updateReservation(updatedReservation);
    }

    public void deleteReservation(Long id) {
    	reservationDAO.deleteReservation(id);
    }

    public List<Reservation> getReservationsForUser(Long id) {
        return reservationDAO.getReservationsForUser(id);
    }
}
