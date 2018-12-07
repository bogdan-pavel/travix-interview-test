package com.travix.medusa.busyflights.domain.crazyair;

import java.util.List;

public interface CrazyAirService {
    /**
     * Get flights by {@link CrazyAirRequest}
     * @param crazyAirRequest
     * @return a list of {@link CrazyAirResponse}
     */
    List<CrazyAirResponse> getFlights(CrazyAirRequest crazyAirRequest);
}
