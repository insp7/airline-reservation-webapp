package com.airlinesReservationRESTApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.airlinesReservationRESTApp.models.Flight;

public interface FlightRepository extends CrudRepository<Flight, Long>{

}
