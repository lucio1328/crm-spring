package com.lucio.crmspring.services;

import com.lucio.crmspring.dto.MapDTO;
import com.lucio.crmspring.dto.StatistiqueResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class StatistiqueService {
    private final WebClient webClient;

    public StatistiqueService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8000/api").build();
    }

    public Mono<StatistiqueResponse> getStatistiques(String token) {
        return webClient.get()
                .uri("/statistiques")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(StatistiqueResponse.class);
    }

    public Mono<MapDTO> getMonthlyRevenueChart(String token) {
        return webClient.get()
                .uri("/payments/chart")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Integer>>() {})
                .map(data -> {
                    MapDTO mapDTO = new MapDTO();
                    mapDTO.setDataInteger(data);
                    return mapDTO;
                });
    }

    public MapDTO getProjectCountByStatus(String token) {
        return webClient.get()
                .uri("/projects/chart")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Integer>>() {})
                .map(data -> {
                    MapDTO mapDTO = new MapDTO();
                    mapDTO.setDataInteger(data);
                    return mapDTO;
                })
                .block();
    }

}
