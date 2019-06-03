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
import java.util.stream.Collectors;

@RestController
public class ViolationController {

    private ViolationService violationService;

    @GetMapping(value = "/violation")
    public ModelAndView getRooms(Authentication authentication){
        ModelAndView roomView = new ModelAndView("violation");
        // User user = (User) authentication.getPrincipal();
        List<Violation> violations = violationService.getAll();

        roomView.addObject("violations", violations);

        return roomView;
    }

    @GetMapping(value = "/violation/{1d}")
    public ModelAndView getRoom(@PathVariable("id") Integer id, Authentication authentication){
        ModelAndView roomView = new ModelAndView("/violation");
        Optional<Violation> violation = violationService.getById(id);
        violation.ifPresent(v -> roomView.addObject("violation", v));
        return roomView;
    }

    @PostMapping(value = "careate-violation")
    public ModelAndView createLecture(@RequestBody Violation violation, UriComponentsBuilder ucBuilder, Authentication authentication) {
        ModelAndView violationView = new ModelAndView("/violation");
        User user = (User) authentication.getPrincipal();

        violationService.addViolation(violation);

        return getRooms(authentication);
    }

    @Autowired
    public void setViolationService(ViolationService violationService) {
        this.violationService = violationService;
    }
}
