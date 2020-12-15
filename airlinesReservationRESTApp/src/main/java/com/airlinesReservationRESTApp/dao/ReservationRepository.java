package com.airlinesReservationRESTApp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.airlinesReservationRESTApp.models.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query(value = "SELECT * FROM reservations r1 WHERE r1.id = (SELECT max(id) FROM reservations r2)", nativeQuery = true)
    Long findLastInsertedRecord();
}
