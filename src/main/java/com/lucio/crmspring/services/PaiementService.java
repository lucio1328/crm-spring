package com.lucio.crmspring.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PaiementService {
    private final WebClient webClient;

    public PaiementService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8000/api").build();
    }
    public Mono<String> deletePaiement(String token, Integer paymentId) {
        return webClient.delete()
                .uri("/paiement/delete/" + paymentId)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(String.class);
    }

}
