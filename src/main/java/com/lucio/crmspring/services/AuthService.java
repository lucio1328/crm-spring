package com.lucio.crmspring.services;

import com.lucio.crmspring.dto.LoginResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class AuthService {
    private final WebClient webClient;

    public AuthService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8000/api").build();
    }

    public Mono<LoginResponse> login(String email, String password) {
        return webClient.post()
                .uri("/login")
                .bodyValue(Map.of("email", email, "password", password))
                .retrieve()
                .bodyToMono(LoginResponse.class);
    }
}
