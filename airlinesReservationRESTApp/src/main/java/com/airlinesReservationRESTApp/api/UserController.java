package com.airlinesReservationRESTApp.api;

import com.airlinesReservationRESTApp.models.AuthenticationDetail;
import com.airlinesReservationRESTApp.models.User;

import com.airlinesReservationRESTApp.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public void post(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping
    public void update(@RequestBody User updatedUser) {
        userService.updateUser(updatedUser);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping(path = "/authenticate")
    public String authenticate(@RequestBody AuthenticationDetail userDetails) {
        return userService.authenticateUser(userDetails);
    }
}
