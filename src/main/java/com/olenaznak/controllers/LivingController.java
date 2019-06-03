package com.olenaznak.controllers;

import com.olenaznak.models.Living;
import com.olenaznak.models.Student;
import com.olenaznak.services.LivingService;
import com.olenaznak.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class LivingController {

    private LivingService livingService;

    private StudentService studentService;

    @GetMapping(value = "/livings")
    public ModelAndView getLivings(Authentication authentication) {
        ModelAndView roomView = new ModelAndView("living");
        // User user = (User) authentication.getPrincipal();
        List<Living> livings = livingService.getAll();

        roomView.addObject("livings", livings);

        return roomView;
    }

    @PostMapping(value = "careate-living")
    public ModelAndView createLecture(@RequestBody Living living, UriComponentsBuilder ucBuilder, Authentication authentication) {
        ModelAndView livingView = new ModelAndView("/living");
        User user = (User) authentication.getPrincipal();

        livingService.addLiving(living);

        return getLivings(authentication);
    }

    @GetMapping(value = "/livings-by-student/{id}")
    public ModelAndView getLivingsByStudent(@PathVariable int id, Authentication authentication) {

        ModelAndView roomView = new ModelAndView("living");
        // User user = (User) authentication.getPrincipal();
        Living living = livingService.getByRoom(id);

        roomView.addObject("livings", living);
 
        return roomView; 
    }

    @GetMapping(value = "/livings-by-room/{id}")
    public ModelAndView getLivingsByRoom(@PathVariable int id, Authentication authentication) {

        ModelAndView roomView = new ModelAndView("living");
        // User user = (User) authentication.getPrincipal();
        Optional<Student> student = studentService.getStudentById(id);
        Living living = null;
        if(student.isPresent()){
            living = livingService.getByStudent(student.get().getName(), student.get().getSurname());
        }

        roomView.addObject("livings", living);

        return roomView;
    }


    @Autowired
    public void setLivingService(LivingService livingService) {
        this.livingService = livingService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
