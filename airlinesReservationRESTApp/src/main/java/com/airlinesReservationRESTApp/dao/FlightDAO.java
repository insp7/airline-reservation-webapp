package com.airlinesReservationRESTApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.airlinesReservationRESTApp.models.FlightPreference;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.airlinesReservationRESTApp.models.Flight;

@Repository
public class FlightDAO {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightDAO(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	public boolean saveFlight(Flight flight) {
		if(flightRepository.existsById(flight.getId()))
			return false;
		flightRepository.save(flight);
		return true;
	}
	
	public List<Flight> getFlights() {
		Iterable<Flight> iterable = flightRepository.findAll();
        List<Flight> flights = new ArrayList<>();
        iterable.forEach(flights::add);

        return flights;
	}
	
	public Flight getFlight(Long id) {
		Optional<Flight> flightOptional = flightRepository.findById(id);
        return flightOptional.isPresent() ? flightOptional.get() : null;
	}

	public boolean updateFlight(Flight updatedFlight) {
		if(flightRepository.existsById(updatedFlight.getId())) {
			flightRepository.save(updatedFlight);
			return true;
		}
		return false;
	}

	public void deleteFlight(Long id) {
    	flightRepository.deleteById(id);
	}


    public List<Flight> getFlightsByUserPreference(FlightPreference flightPreference) {
    	long source = flightPreference.getSource();
    	long destination = flightPreference.getDestination();
    	String departureDate = flightPreference.getDepartureDate();
    	String passengersCount = flightPreference.getPassengersCount();
    	String returnDate = flightPreference.getReturnDate();

		List<Flight> departureDateFlights = flightRepository.findFlightByUserPreference(source, destination, departureDate, passengersCount);

		if(returnDate != null) {
			List<Flight> returnDateFlights = flightRepository.findFlightByUserPreference(destination, source, returnDate, passengersCount);
			List<Flight> flights = Stream.concat(departureDateFlights.stream(), returnDateFlights.stream()).collect(Collectors.toList());
//			return new Gson().toJson(flights);
			return flights;
		}

//		return new Gson().toJson(departureDateFlights);
		return departureDateFlights;
    }

	public List<Integer> getReservedSeatsByFlightId(Long id) {
    	return flightRepository.getReservedSeatsByFlightId(id);
	}
}
