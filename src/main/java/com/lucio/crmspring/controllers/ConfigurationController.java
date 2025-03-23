package com.lucio.crmspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/configuration")
public class ConfigurationController {
    @GetMapping
    public ModelAndView config() {
        ModelAndView modelAndView = new ModelAndView("layout/modele");
        modelAndView.addObject("view", "pages/configuration");

        return modelAndView;
    }
}
