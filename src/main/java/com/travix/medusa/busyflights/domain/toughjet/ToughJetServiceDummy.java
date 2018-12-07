package com.travix.medusa.busyflights.domain.toughjet;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToughJetServiceDummy implements ToughJetService {

    /**
     * Crates dummy flights
     * @param toughJetRequests
     * @return
     */
    @Override
    public List<ToughJetResponse> getFlights(ToughJetRequest toughJetRequests) {
        List<ToughJetResponse> toughJetResponses = new ArrayList<>();
        toughJetResponses.add(createDummyFlight(toughJetRequests,250.24));
        toughJetResponses.add(createDummyFlight(toughJetRequests,345.253));
        return  toughJetResponses;
    }

    /**
     * Creates dummy flight
     * @param toughJetRequest
     * @param price
     * @return
     */
    private ToughJetResponse createDummyFlight(ToughJetRequest toughJetRequest, Double price) {
        ToughJetResponse toughJetResponse = new ToughJetResponse();
        toughJetResponse.setDepartureAirportName(toughJetRequest.getOrigin());
        toughJetResponse.setArrivalAirportName(toughJetRequest.getDestination());
        toughJetResponse.setInboundDateTime(toughJetRequest.getReturnDate());
        toughJetResponse.setOutboundDateTime(toughJetRequest.getDepartureDate());
        toughJetResponse.setBasePrice(price * toughJetRequest.getNumberOfPassengers());
        toughJetResponse.setCarrier("Tough Jet");
        toughJetResponse.setDiscount(price*0.1);
        toughJetResponse.setTax(price*0.2);
        return toughJetResponse;
    }
}
