package com.airlinesReservationRESTApp.api;


import com.airlinesReservationRESTApp.models.TestMessage;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id) {
        String msg = "Hello, your id is " + id;
        try {
            return new ObjectMapper().writeValueAsString(new TestMessage(msg));
        } catch(IOException e) {
            e.printStackTrace();
            return "{'error':'IOException'}";
        }
    }
}
