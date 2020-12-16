package com.airlinesReservationRESTApp.dao;

import com.airlinesReservationRESTApp.models.Passenger;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM passengers WHERE reservationId = :id", nativeQuery = true)
    int deletePassengerByReservationId(@Param("id") Long id);
}
