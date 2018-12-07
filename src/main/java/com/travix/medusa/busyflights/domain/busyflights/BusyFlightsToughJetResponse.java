package com.travix.medusa.busyflights.domain.busyflights;

import java.util.Date;

public class BusyFlightsToughJetResponse {

    private String carrier;
    //used wrapper instead of primitives to avoid default in case of unset value
    private Double basePrice;
    private Double tax;
    private Double discount;
    private String departureAirportName;
    private String arrivalAirportName;
    private Date outboundDateTime;
    private Date inboundDateTime;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public Date getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(Date outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public Date getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(Date inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }
}
