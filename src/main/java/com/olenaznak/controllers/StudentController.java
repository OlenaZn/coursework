package com.olenaznak.controllers;

import com.olenaznak.models.Student;
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
public class StudentController {

    private StudentService studentService;

    @GetMapping(value = "/student")
    public ModelAndView getStudents(Authentication authentication){
        ModelAndView studentView = new ModelAndView("violation");
        // User user = (User) authentication.getPrincipal();
        List<Student> violations = studentService.getAllStudents();

        studentView.addObject("violations", violations);

        return studentView;
    }

    @GetMapping(value = "/student/{1d}")
    public ModelAndView getStudent(@PathVariable("id") Integer id, Authentication authentication){
        ModelAndView studentView = new ModelAndView("/violation");
        Optional<Student> studentOptional = studentService.getStudentById(id);
        studentOptional.ifPresent(s -> studentView.addObject("violation", s));
        return studentView;
    }

    @PostMapping(value = "/careate-student")
    public ModelAndView createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder, Authentication authentication) {
        ModelAndView studentView = new ModelAndView("/student");
        User user = (User) authentication.getPrincipal();

        studentService.addStudent(student);

        return getStudents(authentication);
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
