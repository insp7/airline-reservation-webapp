package com.airlinesReservationRESTApp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.airlinesReservationRESTApp.models.Reservation;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query(value = "SELECT * FROM reservations r1 WHERE r1.id = (SELECT max(id) FROM reservations r2)", nativeQuery = true)
    Long findLastInsertedRecord();

    @Query(value = "SELECT * FROM reservations r1 WHERE r1.userId = :userId", nativeQuery = true)
    List<Reservation> getReservationsForUserId(@Param("userId") Long id);


}
