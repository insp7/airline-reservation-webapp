package com.airlinesReservationRESTApp.dao;

import com.airlinesReservationRESTApp.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM users u WHERE u.email = :email", nativeQuery = true)
    User findUserByEmail(@Param("email") String email);
}
