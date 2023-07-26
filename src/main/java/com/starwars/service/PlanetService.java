package com.starwars.service;

import com.starwars.model.Planet;
import com.starwars.model.SwapiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

//it implements the core logic, will return the number of residents
@Service
public class PlanetService {

    private final WebClient webClient;

    public PlanetService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://swapi.dev/api/").build();
    }

    public int getResidentCount(String planetName) {
        SwapiResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("planets")
                        .queryParam("search", planetName)
                        .build())
                .retrieve()
                .bodyToMono(SwapiResponse.class)
                .block();

        if(response != null && !response.getResults().isEmpty()) {
            Planet planet = response.getResults().get(0);
            return planet.getResidents().size();
        }

        return 0;
    }
}
