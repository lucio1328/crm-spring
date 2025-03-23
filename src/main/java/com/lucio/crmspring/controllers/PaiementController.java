package com.lucio.crmspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/paiement")
public class PaiementController {
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") int id) {
        return new ModelAndView();
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        return new ModelAndView();
    }
}
