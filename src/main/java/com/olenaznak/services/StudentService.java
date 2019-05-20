package com.olenaznak.services;

import com.olenaznak.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<Student> getStudentById(int id);

    List<Student> getAllStudents();

    Optional<Student> getByNameAndSurname(String name, String surname);

    List<Student> getStudentsByHobby(String hobby);

    List<Student> getStudentsByInstitution(String institution);

    void addStudent(Student student);

    void deleteStudent(Student student);
}
