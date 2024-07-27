package com.kafka.demo.controller;


import com.kafka.demo.services.LocationService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {
        int range = 100;
        while(range>0) {
            locationService.uplodateLocation(Math.random() + ", " + Math.random());
            Thread.sleep(1000);
            range--;
        }

        return new ResponseEntity<>(Map.of(), HttpStatus.OK);
    }
}
