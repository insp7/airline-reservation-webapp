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

import com.airlinesReservationRESTApp.models.Flight;
import com.airlinesReservationRESTApp.services.FlightService;


@RestController
@RequestMapping("/flights")
@CrossOrigin
public class FlightController {

	 	@Autowired
	 	private FlightService flightService;
	 
	 	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Flight> getAll() {
	        return flightService.getFlights();
	    }

	    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public Flight getFlight(@PathVariable Long id) {
	        return flightService.getFlight(id);
	    }

	    @PostMapping
	    public void post(@RequestBody Flight flight) {
	        flightService.addFlight(flight);
	    }

	    @PutMapping(path = "/{id}")
	    public void update(@PathVariable Long id, @RequestBody Flight updatedFlight) {
	        flightService.updateFlight(updatedFlight);
	    }

	    @DeleteMapping(path = "/{id}")
	    public void delete(@PathVariable Long id) {
	        flightService.deleteFlight(id);
	    }
}
