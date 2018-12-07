package com.travix.medusa.busyflights.domain.crazyair;

import java.util.Date;

/**
 * changed all fields to be the same as the others request objects
 */
public class CrazyAirRequest {

    private String origin;
    private String destination;
    private Date departureDate;
    private Date returnDate;
    //used wrapper instead of primitives to avoid default in case of unset value
    private Integer numberOfPassengers;

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }
}
