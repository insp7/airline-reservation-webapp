package com.airlinesReservationRESTApp.api;

import java.util.List;

import com.google.gson.Gson;
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

import com.airlinesReservationRESTApp.models.FlightPreference;
import com.airlinesReservationRESTApp.models.ResponseStatus;
import com.airlinesReservationRESTApp.models.Flight;
import com.airlinesReservationRESTApp.services.FlightService;


@RestController
@RequestMapping("/flights")
@CrossOrigin
public class FlightController {
	private final FlightService flightService;

	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> getAll() {
		return flightService.getFlights();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flight getFlight(@PathVariable Long id) {
		return flightService.getFlight(id);
	}

	@PostMapping
	public ResponseStatus post(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}

	@PutMapping
	public ResponseStatus update(@RequestBody Flight updatedFlight) {
		return flightService.updateFlight(updatedFlight);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable Long id) {
		flightService.deleteFlight(id);
	}

	@PostMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> getFlightsByUserPreference(@RequestBody FlightPreference flightPreference) {
		Gson gson =new Gson();
		System.out.println(gson.toJson(flightPreference));
		List<Flight> flights = flightService.getFlightsByUserPreference(flightPreference);
		System.out.println(gson.toJson(flights));
		return flights;
	}

	@GetMapping(path = "/reserved-seats/{id}")
	public String getReservedSeats(@PathVariable Long id) {
		return flightService.getReservedSeatsByFlightId(id);
	}
}
