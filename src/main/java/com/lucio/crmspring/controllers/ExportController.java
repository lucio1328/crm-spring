package com.lucio.crmspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ExportController {
    @GetMapping
    public ModelAndView export() {
        return new ModelAndView();
    }
}
