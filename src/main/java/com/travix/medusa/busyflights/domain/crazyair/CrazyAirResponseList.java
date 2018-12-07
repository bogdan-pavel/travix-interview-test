package com.travix.medusa.busyflights.domain.crazyair;

import java.util.ArrayList;
import java.util.List;

/**
 * Returns a list of {@link CrazyAirResponse}
 */
public class CrazyAirResponseList {

    private List<CrazyAirResponse> crazyAirResponses;

    public CrazyAirResponseList(){
        crazyAirResponses = new ArrayList<>();
    }

    public List<CrazyAirResponse> getCrazyAirResponses() {
        return crazyAirResponses;
    }

    public void setCrazyAirResponses(List<CrazyAirResponse> crazyAirResponses) {
        this.crazyAirResponses = crazyAirResponses;
    }
}
