package com.lucio.crmspring.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

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

    public Mono<String> updatePaiement(String token, Integer paymentId, Double amount) {
        return webClient.put()
                .uri("/paiement/update/" + paymentId)
                .header("Authorization", "Bearer " + token)
                .bodyValue(Map.of("amount", amount))
                .retrieve()
                .onStatus(
                        status -> status.isError(),
                        response -> response.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new RuntimeException("Erreur API: " + errorBody)))
                )
                .bodyToMono(String.class);
    }

}
