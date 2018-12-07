package com.travix.medusa.busyflights.domain.crazyair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("crazy-air")
public class CrazyAirController {

    @Autowired
    private CrazyAirServiceDummy crazyAirService;

    @GetMapping(value = "flights", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CrazyAirResponse>> getFlights(@RequestParam String origin, @RequestParam String destination,
                                                             @RequestParam @DateTimeFormat(pattern = "MM.dd.yyyy") Date departureDate,
                                                             @RequestParam @DateTimeFormat(pattern = "MM.dd.yyyy") Date returnDate,
                                                             @RequestParam Integer numberOfPassengers) {
        CrazyAirRequest crazyAirRequest = createCrazyRequest(origin, destination, departureDate, returnDate, numberOfPassengers);
        return new ResponseEntity<>(crazyAirService.getFlights(crazyAirRequest), HttpStatus.OK);
    }

    private CrazyAirRequest createCrazyRequest(String origin, String destination, Date departureDate, Date returnDate, Integer numberOfPassengers) {
        CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
        crazyAirRequest.setOrigin(origin);
        crazyAirRequest.setDestination(destination);
        crazyAirRequest.setDepartureDate(departureDate);
        crazyAirRequest.setReturnDate(returnDate);
        crazyAirRequest.setNumberOfPassengers(numberOfPassengers);
        return crazyAirRequest;
    }

}
