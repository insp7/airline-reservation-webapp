package com.airlinesReservationRESTApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.airlinesReservationRESTApp.models.Flight;

@Repository
public class FlightDAO {
	
	@Autowired
    private FlightRepository flightRepository;

	public void saveFlight(Flight flight) {
		 if(flightRepository.existsById(flight.getId()))
	            System.out.println("Flight Already Exists.");
	        else {
	            flightRepository.save(flight);
	            System.out.println("Flight Saved.");
	        }
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

	public void updateFlight(Flight updatedFlight) {
		 if(flightRepository.existsById(updatedFlight.getId())) {
	            flightRepository.save(updatedFlight);
	        } else {
	            System.out.println("Trying to update a flight which doesn't exist.");
	        }
	}

	public void deleteFlight(Long id) {
		 flightRepository.deleteById(id);
		
	}
	
	

}
