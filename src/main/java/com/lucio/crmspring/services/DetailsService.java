package com.lucio.crmspring.services;

import com.lucio.crmspring.dto.Client;
import com.lucio.crmspring.dto.Project;
import com.lucio.crmspring.dto.Task;
import com.lucio.crmspring.dto.Offer;
import com.lucio.crmspring.dto.Invoice;
import com.lucio.crmspring.dto.Payment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DetailsService {
    private final WebClient webClient;

    public DetailsService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8000/api").build();
    }

    public Mono<List<Client>> getClients(String token) {
        return webClient.get()
                .uri("/details/clients")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToFlux(Client.class)
                .collectList();
    }

    public Mono<List<Project>> getProjets(String token) {
        return webClient.get()
                .uri("/details/projets")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToFlux(Project.class)
                .collectList();
//                .doOnNext(projects -> System.out.println("Projets récupérés : " + projects));
    }

    public Mono<List<Task>> getTaches(String token) {
        return webClient.get()
                .uri("/details/taches")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToFlux(Task.class)
                .collectList();
    }

    public Mono<List<Offer>> getOffres(String token) {
        return webClient.get()
                .uri("/details/offres")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToFlux(Offer.class)
                .collectList();
    }

    public Mono<List<Invoice>> getFactures(String token) {
        return webClient.get()
                .uri("/details/factures")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToFlux(Invoice.class)
                .collectList();
    }

    public Mono<List<Payment>> getPaiements(String token) {
        return webClient.get()
                .uri("/details/paiements")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToFlux(Payment.class)
                .collectList();
    }
}
