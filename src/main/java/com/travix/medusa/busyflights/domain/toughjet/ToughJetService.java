package com.travix.medusa.busyflights.domain.toughjet;

import java.util.List;

public interface ToughJetService {
    /**
     * Get flights by {@link ToughJetRequest}
     * @param toughJetRequests
     * @return a list of {@link ToughJetResponse}
     */
    List<ToughJetResponse> getFlights(ToughJetRequest toughJetRequests);
}
