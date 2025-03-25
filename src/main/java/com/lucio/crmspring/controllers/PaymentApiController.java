package com.lucio.crmspring.controllers;

import java.util.Collections;
import java.util.Map;

import com.lucio.crmspring.dto.MapDTO;
import com.lucio.crmspring.services.StatistiqueService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentApiController {

    @Autowired
    private StatistiqueService dashboardService;

    @GetMapping("/chart")
    public Map<String, Integer> getMonthlyRevenueChart(HttpSession session) {
        String token = (String) session.getAttribute("token");

        MapDTO mapDTO = dashboardService.getMonthlyRevenueChart(token).block();

        return (mapDTO != null) ? mapDTO.getDataInteger() : Collections.emptyMap();
    }

}
