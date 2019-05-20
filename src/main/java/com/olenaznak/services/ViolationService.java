package com.olenaznak.services;

import com.olenaznak.models.Student;
import com.olenaznak.models.Violation;

import java.util.List;
import java.util.Optional;

public interface ViolationService {
    List<Violation> getAll();

    Optional<Violation> getById(int id);

    Optional<Violation> getByStudent(String name, String surname);

    void addViolation(Violation violation);

    void deleteViolation(Violation violation);
}
