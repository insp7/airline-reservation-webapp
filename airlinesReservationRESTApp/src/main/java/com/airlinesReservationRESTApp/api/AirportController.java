package com.airlinesReservationRESTApp.api;

import com.airlinesReservationRESTApp.models.Airport;
import com.airlinesReservationRESTApp.services.AirportService;
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
@RequestMapping("/airports")
@CrossOrigin
public class AirportController {
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Airport> getAll() {
        return airportService.getAirports();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Airport getAirport(@PathVariable Long id) {
        return airportService.getAirport(id);
    }

    @PostMapping
    public void post(@RequestBody Airport airport) {
        airportService.addAirport(airport);
    }

    @PutMapping
    public void update(@RequestBody Airport updatedAirport) {
        airportService.updateAirport(updatedAirport);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }
}
