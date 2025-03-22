package com.lucio.crmspring.controllers;

import com.lucio.crmspring.dto.LoginResponse;
import com.lucio.crmspring.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.ModelAndView;
import reactor.core.publisher.Mono;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class LoginController {
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Mono<ModelAndView> login(@RequestParam("email") String email,
                                    @RequestParam("password") String password,
                                    HttpSession session, Model model) {
        return authService.login(email, password)
                .map(response -> {
                    session.setAttribute("token", response.getToken());
                    session.setAttribute("user", response.getUser());
                    model.addAttribute("view", "pages/dashboard");
                    return new ModelAndView("layout/modele");
                })
                .onErrorResume(WebClientResponseException.class, ex -> {
                    model.addAttribute("error", "Identifiants incorrects !");
                    return Mono.just(new ModelAndView("index"));
                });
    }
}
