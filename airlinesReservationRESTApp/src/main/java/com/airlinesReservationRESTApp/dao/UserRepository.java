package com.airlinesReservationRESTApp.dao;

import com.airlinesReservationRESTApp.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    
}
