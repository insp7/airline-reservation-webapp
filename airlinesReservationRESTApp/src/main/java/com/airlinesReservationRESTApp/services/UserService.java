package com.airlinesReservationRESTApp.services;

import com.airlinesReservationRESTApp.dao.UserDAO;


import com.airlinesReservationRESTApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void addUser(User user) {
        userDAO.saveUser(user);
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    public void updateUser(User updatedUser) {
        userDAO.updateUser(updatedUser);
    }

    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
