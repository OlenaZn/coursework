package com.olenaznak.controllers;

import com.olenaznak.models.Violation;
import com.olenaznak.services.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class ViolationController {

    private ViolationService violationService;

    @GetMapping(value = "/violation")
    public ModelAndView getViolations(Authentication authentication){
        ModelAndView violationView = new ModelAndView("violation");
        // User user = (User) authentication.getPrincipal();
        List<Violation> violations = violationService.getAll();

        violationView.addObject("violations", violations);

        return violationView;
    }

    @GetMapping(value = "/violation/{1d}")
    public ModelAndView getViolation(@PathVariable("id") Integer id, Authentication authentication){
        ModelAndView violationView = new ModelAndView("/violation");
        Optional<Violation> violation = violationService.getById(id);
        violation.ifPresent(v -> violationView.addObject("violation", v));
        return violationView;
    }

    @PostMapping(value = "/careate-violation")
    public ModelAndView createViolation(@RequestBody Violation violation, UriComponentsBuilder ucBuilder, Authentication authentication) {
        ModelAndView violationView = new ModelAndView("/violation");
        User user = (User) authentication.getPrincipal();

        violationService.addViolation(violation);

        return getViolations(authentication);
    }

    @Autowired
    public void setViolationService(ViolationService violationService) {
        this.violationService = violationService;
    }
}
