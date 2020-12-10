package com.airlinesReservationRESTApp.dao;


import com.airlinesReservationRESTApp.models.AuthenticationDetail;
import com.airlinesReservationRESTApp.models.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO {
    private final UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        if(userRepository.existsById(user.getId()))
            System.out.println("User Already Exists.");
        else {
            userRepository.save(user);
            System.out.println("User Saved.");
        }
    }

    public List<User> getUsers() {
        Iterable<User> iterable = userRepository.findAll();
        List<User> users = new ArrayList<>();
        iterable.forEach(users::add);

        return users;
    }

    public User getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.isPresent() ? userOptional.get() : null;
    }

    public void updateUser(User updatedUser) {
        if(userRepository.existsById(updatedUser.getId())) {
            userRepository.save(updatedUser);
        } else {
            System.out.println("Trying to update a user which doesn't exist.");
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public String authenticateUser(AuthenticationDetail userDetails) {
        User user = userRepository.findUserByEmail(userDetails.getEmail());
        if(user != null && user.getPassword().equals(userDetails.getPassword())) {
            return "User Authenticated: " + userDetails;
        }
        return "Access Denied! Wrong email/password.";
    }
}
