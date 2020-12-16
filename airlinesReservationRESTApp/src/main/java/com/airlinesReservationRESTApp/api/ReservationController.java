package com.airlinesReservationRESTApp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airlinesReservationRESTApp.models.Reservation;
import com.airlinesReservationRESTApp.services.ReservationService;


@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
	public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reservation> getAll() {
        return reservationService.getReservations();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.getReservation(id);
    }

    @PostMapping
    public String post(@RequestBody Reservation reservation) {
    	return reservationService.addReservation(reservation);
    }

    @PutMapping
    public void update(@RequestBody Reservation updatedReservation) {
    	reservationService.updateReservation(updatedReservation);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
    	reservationService.deleteReservation(id);
    }

    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reservation> getReservationsForUser(@PathVariable Long id) {
        return reservationService.getReservationsForUser(id);
    }
}
