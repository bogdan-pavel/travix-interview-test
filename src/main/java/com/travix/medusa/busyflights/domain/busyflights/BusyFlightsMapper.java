package com.travix.medusa.busyflights.domain.busyflights;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class BusyFlightsMapper {

    @Autowired
    BusyFlightsAdapter busyFlightsAdapter;

    public List<BusyFlightsResponse> convertFromJson(String crazyAirFlightsJson) {
        final List<BusyFlightsResponse> busyFlightsResponses;
        try {
            busyFlightsResponses = new ArrayList<>(new ObjectMapper().readValue(crazyAirFlightsJson, new TypeReference<List<BusyFlightsResponse>>() {
            }));
        } catch (IOException e) {
            throw new AssertionError("An IOException occurred when this was assumed to be impossible.");
        }
        busyFlightsResponses.forEach(flight -> flight.setSupplier("CrazyAir"));
        return busyFlightsResponses;

    }

    public List<BusyFlightsResponse> covertFromJsonWithAdapter(String toughJet){
        final List<BusyFlightsToughJetResponse> busyFlightsResponses;
        try {
            busyFlightsResponses = new ObjectMapper().readValue(toughJet, new TypeReference<List<BusyFlightsToughJetResponse>>(){});
        } catch (IOException e) {
            throw new AssertionError("An IOException occurred when this was assumed to be impossible.");
        }
        return busyFlightsResponses.stream().map(o -> busyFlightsAdapter.toughJetToBusyFlightResponse(o)).collect(toList());
    }

}