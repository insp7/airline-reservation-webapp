package com.airlinesReservationRESTApp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.airlinesReservationRESTApp.models.Flight;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {

    @Query(value = "SELECT * FROM flights f WHERE f.source = :source AND f.destination = :destination AND f.departureDate LIKE %:departureDate% AND f.capacity > :passengersCount", nativeQuery = true)
    List<Flight> findFlightByUserPreference(@Param("source") long source, @Param("destination") long destination, @Param("departureDate") String departureDate, @Param("passengersCount") String passengersCount);

    @Query(value = "SELECT seatNo FROM passengers p INNER JOIN reservations r ON p.reservationID = r.id WHERE flightId = :id", nativeQuery = true)
    List<Integer> getReservedSeatsByFlightId(@Param("id") Long id);
}
