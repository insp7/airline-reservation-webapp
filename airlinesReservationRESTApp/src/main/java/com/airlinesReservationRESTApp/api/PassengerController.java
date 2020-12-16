package com.airlinesReservationRESTApp.api;

import com.airlinesReservationRESTApp.models.Passenger;
import com.airlinesReservationRESTApp.services.PassengerService;

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

import java.util.List;

@RestController
@RequestMapping("/passengers")
@CrossOrigin
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Passenger> getAll() {
        return passengerService.getPassengers();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Passenger getPassenger(@PathVariable Long id) {
        return passengerService.getPassenger(id);
    }

    @PostMapping
    public void post(@RequestBody Passenger passenger) {
        passengerService.addPassenger(passenger);
    }

    @PostMapping(path = "/multiple")
    public void post(@RequestBody Passenger[] passengers) {
        for (Passenger passenger : passengers) {
            passengerService.addPassenger(passenger);
        }
    }

    @PutMapping
    public void update(@RequestBody Passenger updatedPassenger) {
        passengerService.updatePassenger(updatedPassenger);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }

    @DeleteMapping(path = "/reservationId/{id}")
    public Integer deletePassengerByReservationId(@PathVariable Long id) {
        return passengerService.deletePassengerByReservationId(id);
    }
}
