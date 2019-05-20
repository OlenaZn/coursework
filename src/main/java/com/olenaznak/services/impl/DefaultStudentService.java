package com.olenaznak.services.impl;

import com.olenaznak.dao.StudentDao;
import com.olenaznak.models.Student;
import com.olenaznak.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultStudentService implements StudentService {

    private StudentDao studentDao;

    @Override
    public Optional<Student> getStudentById(int id) {
        return studentDao.getById(id);
    }

    @Override
    public List<Student> getAllStudents() {
       return studentDao.getAll();
    }

    @Override
    public Optional<Student> getByNameAndSurname(String name, String surname) {
        return studentDao.getByNameAndSurname(name, surname);
    }

    @Override
    public List<Student> getStudentsByHobby(String hobby) {
        return studentDao.getStudentsByHobby(hobby);
    }

    @Override
    public List<Student> getStudentsByInstitution(String institution) {
        return studentDao.getStudentsByInstitution(institution);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteStudent(student);
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
