package com.lucio.crmspring.controllers;

import com.lucio.crmspring.services.ConfigurationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/configuration")
public class ConfigurationController {
    private final ConfigurationService configurationService;

    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @GetMapping
    public ModelAndView config() {
        ModelAndView modelAndView = new ModelAndView("layout/modele");
        modelAndView.addObject("view", "pages/configuration");

        return modelAndView;
    }

    @PostMapping("/insert")
    public Mono<String> insert(@RequestParam("remise_globale") Double remiseGlobale,
                               HttpSession session, RedirectAttributes redirectAttributes) {
        String token = (String) session.getAttribute("token");

        if (token == null) {
            return Mono.just("redirect:/");
        }

        return configurationService.insertConfiguration(token, remiseGlobale)
                .map(response -> {
                    redirectAttributes.addFlashAttribute("message", "Remise globale ajoutée avec succès !");
                    return "redirect:/configuration";
                })
                .onErrorResume(e -> {
                    redirectAttributes.addFlashAttribute("error", "Erreur lors de l'ajout de la remise.");
                    return Mono.just("redirect:/configuration");
                });
    }
}
