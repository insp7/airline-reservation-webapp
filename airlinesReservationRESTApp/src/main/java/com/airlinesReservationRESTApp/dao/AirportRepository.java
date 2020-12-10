package com.airlinesReservationRESTApp.dao;

import com.airlinesReservationRESTApp.models.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Long> {

}
