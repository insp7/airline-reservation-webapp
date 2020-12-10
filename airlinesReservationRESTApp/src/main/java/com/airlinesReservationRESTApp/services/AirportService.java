package com.airlinesReservationRESTApp.services;

import com.airlinesReservationRESTApp.dao.AirportDAO;
import com.airlinesReservationRESTApp.models.Airport;
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

    public void addAirport(Airport airport) {
        airportDAO.saveAirport(airport);
    }

    public List<Airport> getAirports() {
        return airportDAO.getAirports();
    }

    public Airport getAirport(Long id) {
        return airportDAO.getAirport(id);
    }

    public void updateAirport(Airport updatedAirport) {
        airportDAO.updateAirport(updatedAirport);
    }

    public void deleteAirport(Long id) {
        airportDAO.deleteAirport(id);
    }
}