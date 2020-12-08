package com.airlinesReservationRESTApp.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "This is Response from HomeController";
    }
}
