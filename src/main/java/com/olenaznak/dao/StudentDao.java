package com.olenaznak.dao;

import com.olenaznak.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentDao {
    private List<Student> studentList;

    public StudentDao(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentDao() {
        studentList = new ArrayList<>();
    }

    public List<Student> getAll() {
        return studentList;
    }

    public Optional<Student> getById(int id) {
        return studentList.stream().filter(violation -> id == violation.getId()).findFirst();
    }

    public Optional<Student> getByNameAndSurname(String name, String surname) {
        return studentList.stream()
                .filter(student -> student.getName().equals(name)
                        && student.getSurname().equals(surname))
                .findFirst();
    }

    public List<Student> getStudentsByHobby(String hobby) {
        return studentList.stream()
                .filter(student -> student.getHobby().equals(hobby))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByInstitution(String institution) {
        return studentList.stream()
                .filter(student -> student.getinstitution().equals(institution))
                .collect(Collectors.toList());
    }
    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudent(Student student) {
        studentList.remove(student);
    }
}
