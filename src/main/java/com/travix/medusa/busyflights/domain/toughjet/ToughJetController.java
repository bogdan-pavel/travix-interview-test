package com.travix.medusa.busyflights.domain.toughjet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("tough-jet")
public class ToughJetController {

    @Autowired
    private ToughJetServiceDummy toughJetService;

    @GetMapping(value = "flights", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ToughJetResponse>> getToughJetFlights(
            @RequestParam String origin, @RequestParam String destination, @RequestParam @DateTimeFormat(pattern = "MM.dd.yyyy") Date departureDate,
            @RequestParam @DateTimeFormat(pattern = "MM.dd.yyyy") Date returnDate, @RequestParam Integer numberOfPassengers) {
        ToughJetRequest toughJetRequest = crateToughJetRequest(origin, destination, departureDate, returnDate, numberOfPassengers);
        return new ResponseEntity<>(toughJetService.getFlights(toughJetRequest), HttpStatus.OK);
    }

    private ToughJetRequest crateToughJetRequest(String origin, String destination, Date departureDate, Date returnDate, Integer numberOfPassengers) {
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setOrigin(origin);
        toughJetRequest.setDestination(destination);
        toughJetRequest.setDepartureDate(departureDate);
        toughJetRequest.setReturnDate(returnDate);
        toughJetRequest.setNumberOfPassengers(numberOfPassengers);
        return toughJetRequest;

    }
}
