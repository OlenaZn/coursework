package com.olenaznak.services.impl;

import com.olenaznak.dao.ViolationDao;
import com.olenaznak.models.Student;
import com.olenaznak.models.Violation;
import com.olenaznak.services.StudentService;
import com.olenaznak.services.ViolationService;

import java.util.List;
import java.util.Optional;

public class DefaultViolationService implements ViolationService {

    private ViolationDao violationDao;

    private StudentService studentService;

    @Override
    public List<Violation> getAll() {
        return violationDao.getAll();
    }

    @Override
    public Optional<Violation> getById(int id) {
        return violationDao.getById(id);
    }

    @Override
    public Optional<Violation> getByStudent(String name, String surname) {
        Optional<Student> studentOptional = studentService.getByNameAndSurname(name, surname);
        if(studentOptional.isPresent()) {
            return violationDao.getByStudent(studentOptional.get());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void addViolation(Violation violation) {
        violationDao.addViolation(violation);
    }

    @Override
    public void deleteViolation(Violation violation) {
        violationDao.deleteViolation(violation);
    }

    public ViolationDao getViolationDao() {
        return violationDao;
    }

    public void setViolationDao(ViolationDao violationDao) {
        this.violationDao = violationDao;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
