package com.airlinesReservationRESTApp.services;

import com.airlinesReservationRESTApp.dao.AirportDAO;
import com.airlinesReservationRESTApp.models.Airport;
import com.airlinesReservationRESTApp.models.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportDAO airportDAO;

    @Autowired
    public AirportService(AirportDAO airportDAO) {
        this.airportDAO = airportDAO;
    }

    public ResponseStatus addAirport(Airport airport) {
        boolean isAirportAdded = airportDAO.saveAirport(airport);
        ResponseStatus responseStatus;
        if(isAirportAdded)
            responseStatus = new ResponseStatus("Success", "Airport Added Successfully");
        else
            responseStatus = new ResponseStatus("Error", "Cannot Insert! Airport Already Exists.");
        return responseStatus;
    }

    public List<Airport> getAirports() {
        return airportDAO.getAirports();
    }

    public Airport getAirport(Long id) {
        return airportDAO.getAirport(id);
    }

    public ResponseStatus updateAirport(Airport updatedAirport) {
        boolean isAirportUpdated = airportDAO.updateAirport(updatedAirport);
        ResponseStatus responseStatus;
        if(isAirportUpdated)
            responseStatus = new ResponseStatus("Success", "Airport Updated Successfully");
        else
            responseStatus = new ResponseStatus("Error", "Trying to update an airport that doesnt exist.");
        return responseStatus;
    }

    public void deleteAirport(Long id) {
        airportDAO.deleteAirport(id);
    }
}