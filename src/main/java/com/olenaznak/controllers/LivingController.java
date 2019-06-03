package com.olenaznak.controllers;

import com.olenaznak.models.Living;
import com.olenaznak.services.LivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class LivingController {

    private LivingService livingService;

    @GetMapping(value = "/rooms")
    public ModelAndView getRooms(Authentication authentication) {
        ModelAndView roomView = new ModelAndView("living");
        // User user = (User) authentication.getPrincipal();
        List<Living> livings = livingService.getAll();

        roomView.addObject("livings", livings);

        return roomView;
    }
    @Autowired
    public void setLivingService(LivingService livingService) {
        this.livingService = livingService;
    }
}
