package com.travix.medusa.busyflights.domain.busyflights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("busy-flights")
public class BusyFlightsController {

    @Autowired
    BusyFlightsServices busyFlightsServices;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BusyFlightsResponse>> getFlights(@RequestParam String origin, @RequestParam String destination, @RequestParam String departureDate, @RequestParam String returnDate, @RequestParam Integer numberOfPassengers) throws InterruptedException {

        BusyFlightsRequest busyFlightsRequest = createBusyFlightsRequest(origin, destination, departureDate, returnDate, numberOfPassengers);

        return new ResponseEntity<>(busyFlightsServices.getFlights(busyFlightsRequest), HttpStatus.OK);
    }

    private BusyFlightsRequest createBusyFlightsRequest(String origin, String destination, String
            departureDate, String returnDate, Integer numberOfPassengers) {

        BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
        busyFlightsRequest.setOrigin(origin);
        busyFlightsRequest.setDestination(destination);
        busyFlightsRequest.setDepartureDate(departureDate);
        busyFlightsRequest.setReturnDate(returnDate);
        busyFlightsRequest.setNumberOfPassengers(numberOfPassengers);
        return busyFlightsRequest;
    }
}
