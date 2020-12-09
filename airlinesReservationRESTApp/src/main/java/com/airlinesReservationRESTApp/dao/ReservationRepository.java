package com.airlinesReservationRESTApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.airlinesReservationRESTApp.models.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
