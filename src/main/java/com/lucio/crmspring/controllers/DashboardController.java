package com.lucio.crmspring.controllers;

import com.lucio.crmspring.dto.StatistiqueResponse;
import com.lucio.crmspring.services.StatistiqueService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import reactor.core.publisher.Mono;

@Controller
public class DashboardController {
    private final StatistiqueService statistiqueService;

    public DashboardController(StatistiqueService statistiqueService) {
        this.statistiqueService = statistiqueService;
    }

    @GetMapping("/dashboard")
    public Mono<ModelAndView> getDashboard(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");

        System.out.println("🛠️ Token en session: " + token);

        if (token == null) {
            return Mono.just(new ModelAndView("redirect:/"));
        }

        return statistiqueService.getStatistiques(token)
                .map(statistiques -> {
                    model.addAttribute("statistiques", statistiques);
                    model.addAttribute("view", "pages/dashboard");
                    return new ModelAndView("layout/modele");
                })
                .onErrorResume(e -> {
                    model.addAttribute("error", "Impossible de récupérer les statistiques.");
                    model.addAttribute("view", "pages/dashboard");
                    return Mono.just(new ModelAndView("layout/modele"));
                });
    }
}
