package com.travix.medusa.busyflights.domain.toughjet;

import java.util.ArrayList;
import java.util.List;

/**
 * Return a list of {@link ToughJetResponse}
 */
public class ToughJetResponseList {

    private List<ToughJetResponse> toughJetResponses;

    public ToughJetResponseList() {
        toughJetResponses = new ArrayList<>();

    }

    public List<ToughJetResponse> getToughJetResponses() {
        return toughJetResponses;
    }

    public void setToughJetResponses(List<ToughJetResponse> toughJetResponses) {
        this.toughJetResponses = toughJetResponses;
    }
}
