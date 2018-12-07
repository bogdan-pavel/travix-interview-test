package com.travix.medusa.busyflights.domain.busyflights;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusyFlightsResponse {

    private String airline;                 //| airline | Name of Airline |
    private String supplier;                //| supplier | Eg: CrazyAir or ToughJet |
    private Float fare;                     //| fare | Total price rounded to 2 decimals |
    private String departureAirportCode;    //| departureAirportCode | 3 letter IATA code(eg. LHR, AMS) |
    private String destinationAirportCode;  //| destinationAirportCode | 3 letter IATA code(eg. LHR, AMS) |
    private Date departureDate;             //| departureDate | ISO_DATE_TIME format |
    private Date arrivalDate;               //| arrivalDate | ISO_DATE_TIME format |

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Float getFare() {
        return fare;
    }

    public void setFare(Float fare) {
        this.fare = fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
