package com.lucio.crmspring.controllers;

import com.lucio.crmspring.services.DetailsService;
import com.lucio.crmspring.services.PaiementService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@RequestMapping("/details")
public class DetailsController {
    private final DetailsService detailsService;
    private final PaiementService paiementService;

    public DetailsController(DetailsService detailsService, PaiementService paiementService) {
        this.detailsService = detailsService;
        this.paiementService = paiementService;
    }


    private Mono<ModelAndView> handleDetailRequest(String token, String attributeName, Mono<? extends List<?>> data, Model model, String viewName) {
        return data.map(list -> {
            System.out.println("Données envoyées à Thymeleaf pour " + attributeName + ": " + list);
            model.addAttribute(attributeName, list);
            model.addAttribute("view", viewName);
            return new ModelAndView("layout/modele");
        }).onErrorResume(e -> {
            System.err.println("Erreur lors de la récupération des " + attributeName + ": " + e.getMessage());
            model.addAttribute("error", "Impossible de récupérer les données.");
            model.addAttribute("view", viewName);
            return Mono.just(new ModelAndView("layout/modele"));
        });
    }

    @GetMapping("/clients")
    public Mono<ModelAndView> getClients(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        if (token == null) return Mono.just(new ModelAndView("redirect:/"));
        return handleDetailRequest(token, "clients", detailsService.getClients(token), model, "pages/details_clients");
    }

    @GetMapping("/projets")
    public Mono<ModelAndView> getProjets(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        if (token == null) return Mono.just(new ModelAndView("redirect:/"));
        return handleDetailRequest(token, "projets", detailsService.getProjets(token), model, "pages/details_projets");
    }

    @GetMapping("/taches")
    public Mono<ModelAndView> getTaches(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        if (token == null) return Mono.just(new ModelAndView("redirect:/"));
        return handleDetailRequest(token, "taches", detailsService.getTaches(token), model, "pages/details_taches");
    }

    @GetMapping("/offres")
    public Mono<ModelAndView> getOffres(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        if (token == null) return Mono.just(new ModelAndView("redirect:/"));
        return handleDetailRequest(token, "offres", detailsService.getOffres(token), model, "pages/details_offres");
    }

    @GetMapping("/factures")
    public Mono<ModelAndView> getFactures(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        if (token == null) return Mono.just(new ModelAndView("redirect:/"));
        return handleDetailRequest(token, "factures", detailsService.getFactures(token), model, "pages/details_factures");
    }

    @GetMapping("/paiements")
    public Mono<ModelAndView> getPaiements(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        if (token == null) return Mono.just(new ModelAndView("redirect:/"));
        return handleDetailRequest(token, "paiements", detailsService.getPaiements(token), model, "pages/details_paiements");
    }

    @GetMapping("/paiement/update/{id}")
    public ModelAndView update(@PathVariable("id") int id) {
        return new ModelAndView();
    }
    @GetMapping("/paiement/delete/{id}")
    public Mono<String> delete(@PathVariable("id") int id, HttpSession session, RedirectAttributes redirectAttributes) {
        String token = (String) session.getAttribute("token");

        if (token == null) {
            return Mono.just("redirect:/");
        }

        return paiementService.deletePaiement(token, id)
                .map(response -> {
                    redirectAttributes.addFlashAttribute("message", "Paiement supprimé avec succès !");
                    return "redirect:/details/paiements";
                })
                .onErrorResume(e -> {
                    redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression du paiement.");
                    return Mono.just("redirect:/details/paiements");
                });
    }
}
