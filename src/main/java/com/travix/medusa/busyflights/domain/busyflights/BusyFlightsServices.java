package com.travix.medusa.busyflights.domain.busyflights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

import static java.util.stream.Collectors.toList;

@Service
public class BusyFlightsServices {

    @Autowired
    BusyFlightsMapper busyFlightsMapper;

    /**
     * @param busyFlightsRequests
     * @return
     * @throws IOException
     */
    public List<BusyFlightsResponse> getFlights(BusyFlightsRequest busyFlightsRequests) {
        final String toughJetFlights = getToughJetFlights(busyFlightsRequests);
        final String crazyAirFlights = getCrazyAirFlights(busyFlightsRequests);

        final List<BusyFlightsResponse> busyFlightsResponses2 = busyFlightsMapper.convertFromJson(crazyAirFlights);
        final List<BusyFlightsResponse> busyFlightsResponses1 = busyFlightsMapper.covertFromJsonWithAdapter(toughJetFlights);

        busyFlightsResponses1.addAll(busyFlightsResponses2);

        return busyFlightsResponses1.parallelStream().sorted(Comparator.comparing(BusyFlightsResponse::getFare)).collect(toList());
    }
    
    private String getCrazyAirFlights(BusyFlightsRequest request) {
        RestTemplate restTemplateCrazyAir = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String resourceUrlCrazyAir = "http://localhost:8080/crazy-air/flights";
        HttpEntity<String> crazyAirRequestHttpEntity = new HttpEntity<>(headers);
        UriComponentsBuilder uriComponentsBuilder = createUri(request,resourceUrlCrazyAir);

        ResponseEntity<String> responseListCrazyAir = restTemplateCrazyAir.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, crazyAirRequestHttpEntity, String.class);
        return responseListCrazyAir.getBody();
    }

    private String getToughJetFlights(BusyFlightsRequest request) {
        final RestTemplate restTemplateToughJet = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final String resourceUrlToughJet = "http://localhost:8080/tough-jet/flights";
        UriComponentsBuilder uriComponentsBuilder = createUri(request,resourceUrlToughJet);
        HttpEntity toughJetRequestHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseToughJetJson = restTemplateToughJet.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, toughJetRequestHttpEntity, String.class);
        return responseToughJetJson.getBody();
    }

    private UriComponentsBuilder createUri(BusyFlightsRequest request, String url) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        uriComponentsBuilder.queryParam("origin", request.getOrigin());
        uriComponentsBuilder.queryParam("destination", request.getDestination());
        uriComponentsBuilder.queryParam("departureDate", request.getDepartureDate());
        uriComponentsBuilder.queryParam("returnDate", request.getReturnDate());
        uriComponentsBuilder.queryParam("numberOfPassengers", request.getNumberOfPassengers().toString());
        return uriComponentsBuilder;
    }

}