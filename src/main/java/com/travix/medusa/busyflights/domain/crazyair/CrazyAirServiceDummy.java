package com.travix.medusa.busyflights.domain.crazyair;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrazyAirServiceDummy implements CrazyAirService {


    /**
     * Creats dummy flights by {@link CrazyAirRequest}
     * @param crazyAirRequest
     * @return a list of {@link CrazyAirResponse}
     */
    @Override
    public List<CrazyAirResponse> getFlights(CrazyAirRequest crazyAirRequest){
        List<CrazyAirResponse> crazyAirResponses = new ArrayList<>();
        crazyAirResponses.add(createDummyFlight(crazyAirRequest,424.12, "Premium economy"));
        crazyAirResponses.add(createDummyFlight(crazyAirRequest,284.2, "Economy"));
        return crazyAirResponses;
    }

    /**
     * Creates a dummy flight by {@link CrazyAirRequest}
     * @param crazyAirRequest
     * @param price
     * @param cabinClass
     * @return {@link CrazyAirResponse}
     */
    private CrazyAirResponse createDummyFlight(CrazyAirRequest crazyAirRequest, Double price, String cabinClass){
        CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
        crazyAirResponse.setDepartureAirportCode(crazyAirRequest.getOrigin());
        crazyAirResponse.setDestinationAirportCode(crazyAirRequest.getDestination());
        crazyAirResponse.setDepartureDate(crazyAirRequest.getDepartureDate());
        crazyAirResponse.setArrivalDate(crazyAirRequest.getReturnDate());
        crazyAirResponse.setFare(price*crazyAirRequest.getNumberOfPassengers());
        crazyAirResponse.setAirline("Crazy Air");
        crazyAirResponse.setCabinclass(cabinClass);
        return crazyAirResponse;
    }
}
