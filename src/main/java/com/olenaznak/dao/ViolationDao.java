package com.olenaznak.dao;

import com.olenaznak.models.Student;
import com.olenaznak.models.Violation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ViolationDao {
    private List<Violation> violationList;

    public ViolationDao(List<Violation> violationList) {
        this.violationList = violationList;
    }

    public ViolationDao() {
        violationList = new ArrayList<>();
    }

    public List<Violation> getAll() {
        return violationList;
    }

    public Optional<Violation> getById(int id) {
        return violationList.stream().filter(violation -> id == violation.getId()).findFirst();
    }

    public Optional<Violation> getByStudent(Student student) {
        return violationList.stream().filter(violation -> violation.getStudentList().contains(student)).findFirst();
    }

    public void addViolation(Violation violation) {
        violationList.add(violation);
    }

    public void deleteViolation(Violation violation) {
        violationList.remove(violation);
    }
}
