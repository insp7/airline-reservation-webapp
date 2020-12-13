package com.airlinesReservationRESTApp.services;

import com.airlinesReservationRESTApp.dao.UserDAO;
import com.airlinesReservationRESTApp.models.AuthenticationDetail;
import com.airlinesReservationRESTApp.models.User;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

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

    public String authenticateUser(AuthenticationDetail userDetails) {
        User user = userDAO.authenticateUser(userDetails);
        if(user != null) {
            return new Gson().toJson(user);
        }
        return null;
    }
}
