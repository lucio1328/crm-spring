package com.lucio.crmspring.services;

import com.lucio.crmspring.dto.StatistiqueResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
}
