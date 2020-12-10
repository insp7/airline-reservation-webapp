package com.airlinesReservationRESTApp.dao;


import com.airlinesReservationRESTApp.models.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AirportDAO {
    private final AirportRepository airportRepository;

    @Autowired
    public AirportDAO(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void saveAirport(Airport airport) {
        if(airportRepository.existsById(airport.getId()))
            System.out.println("Airport Already Exists.");
        else {
            airportRepository.save(airport);
            System.out.println("Airport Saved.");
        }
    }

    public List<Airport> getAirports() {
        Iterable<Airport> iterable = airportRepository.findAll();
        List<Airport> airports = new ArrayList<>();
        iterable.forEach(airports::add);

        return airports;
    }

    public Airport getAirport(Long id) {
        Optional<Airport> airportOptional = airportRepository.findById(id);
        return airportOptional.isPresent() ? airportOptional.get() : null;
    }

    public void updateAirport(Airport updatedAirport) {
        if(airportRepository.existsById(updatedAirport.getId())) {
            airportRepository.save(updatedAirport);
        } else {
            System.out.println("Trying to update an Airport which doesn't exist.");
        }
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}