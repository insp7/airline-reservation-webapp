package com.airlinesReservationRESTApp.services;

import java.util.List;

import com.airlinesReservationRESTApp.models.FlightPreference;
import com.airlinesReservationRESTApp.models.ResponseStatus;
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

	public ResponseStatus addFlight(Flight flight) {
		 boolean isAdded = flightDAO.saveFlight(flight);
		 ResponseStatus responseStatus;
		if(isAdded)
			responseStatus = new ResponseStatus("Success", "Flight Added Successfully!");
		else
			responseStatus = new ResponseStatus("Error", "Trying to add a flight which doesnt exist!");
		return responseStatus;
	}

	public ResponseStatus updateFlight(Flight updatedFlight) {
		boolean isUpdated = flightDAO.updateFlight(updatedFlight);
		ResponseStatus responseStatus;
		if(isUpdated)
			responseStatus = new ResponseStatus("Success", "Flight Updated Successfully!");
		else
			responseStatus = new ResponseStatus("Error", "Trying to update a flight which doesnt exist!");
		return responseStatus;
	}

	public void deleteFlight(Long id) {
		flightDAO.deleteFlight(id);
	}

    public List<Flight> getFlightsByUserPreference(FlightPreference flightPreference) {
		return flightDAO.getFlightsByUserPreference(flightPreference);
    }

	public String getReservedSeatsByFlightId(Long id) {
		return new Gson().toJson(flightDAO.getReservedSeatsByFlightId(id));
	}
}
