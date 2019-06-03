package com.olenaznak.services;

import com.olenaznak.models.Living;

import java.util.List;
import java.util.Optional;

public interface LivingService {

    List<Living> getAll();

    Optional<Living> getById(int id);

    Living getByStudent(String name, String surname);

    Living getByRoom(int number);

    void addLiving(Living living);

    void deleteLiving(Living living);
}
