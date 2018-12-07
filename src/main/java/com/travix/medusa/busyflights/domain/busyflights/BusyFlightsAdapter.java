package com.travix.medusa.busyflights.domain.busyflights;

import org.springframework.stereotype.Component;

@Component
public class BusyFlightsAdapter {

    public BusyFlightsResponse toughJetToBusyFlightResponse(BusyFlightsToughJetResponse busyFlightsToughJetResponse) {
        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        final Double fare = busyFlightsToughJetResponse.getBasePrice() + busyFlightsToughJetResponse.getTax() - busyFlightsToughJetResponse.getDiscount();
        busyFlightsResponse.setFare((float) (Math.round(fare * 100) / 100));
        busyFlightsResponse.setDestinationAirportCode(busyFlightsToughJetResponse.getArrivalAirportName());
        busyFlightsResponse.setDepartureAirportCode(busyFlightsToughJetResponse.getDepartureAirportName());
        busyFlightsResponse.setDepartureDate(busyFlightsToughJetResponse.getInboundDateTime());
        busyFlightsResponse.setArrivalDate(busyFlightsToughJetResponse.getOutboundDateTime());
        busyFlightsResponse.setAirline(busyFlightsToughJetResponse.getCarrier());
        busyFlightsResponse.setSupplier("ToughJet");

        return busyFlightsResponse;
    }
}
