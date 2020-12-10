package com.airlinesReservationRESTApp.services;

import java.util.List;

import com.airlinesReservationRESTApp.models.FlightPreference;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlinesReservationRESTApp.dao.FlightDAO;
import com.airlinesReservationRESTApp.models.Flight;

@Service
public class FlightService {
	private final FlightDAO flightDAO;

	@Autowired
	public FlightService(FlightDAO flightDAO) {
		this.flightDAO = flightDAO;
	}
	 
	public List<Flight> getFlights() {
		return flightDAO.getFlights();
	}

	public Flight getFlight(Long id) {
		return flightDAO.getFlight(id);
	}

	public void addFlight(Flight flight) {
		 flightDAO.saveFlight(flight);
	}

	public void updateFlight(Flight updatedFlight) {
		   flightDAO.updateFlight(updatedFlight);
	}

	public void deleteFlight(Long id) {
		flightDAO.deleteFlight(id);
	}

    public String getFlightsByUserPreference(FlightPreference flightPreference) {
		return flightDAO.getFlightsByUserPreference(flightPreference);
    }

	public String getReservedSeatsByFlightId(Long id) {
		return new Gson().toJson(flightDAO.getReservedSeatsByFlightId(id));
	}
}
