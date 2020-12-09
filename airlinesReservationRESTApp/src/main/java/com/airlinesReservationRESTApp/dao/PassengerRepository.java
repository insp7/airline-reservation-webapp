package com.airlinesReservationRESTApp.dao;

import com.airlinesReservationRESTApp.models.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {

}
