package com.olenaznak.dao;

import com.olenaznak.models.Living;
import com.olenaznak.models.Room;
import com.olenaznak.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LivingDao {

    private List<Living> livingList;

    public LivingDao(List<Living> livingList) {
        this.livingList = livingList;
    }

    public LivingDao() {
        livingList = new ArrayList<>();
    }

    public List<Living> getAll() {
        return livingList;
    }

    public Optional<Living> getById(int id) {
        return livingList.stream().filter(living -> id == living.getId()).findFirst();
    }

    public Optional<Living> getByStudent(Student student) {
        return livingList.stream().filter(living -> living.getStudent().equals(student)).findFirst();
    }

    public Optional<Living> getByRoom(Room room) {
        return livingList.stream().filter(living -> living.getRoom().equals(room)).findFirst();
    }

    public void addLiving(Living living) {
        livingList.add(living);
    }

    public void deleteLiving(Living living) {
        livingList.remove(living);
    }
}
