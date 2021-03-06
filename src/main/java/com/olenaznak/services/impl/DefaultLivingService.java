package com.olenaznak.services.impl;

import com.olenaznak.dao.LivingDao;
import com.olenaznak.models.Living;
import com.olenaznak.models.Room;
import com.olenaznak.models.Student;
import com.olenaznak.services.LivingService;
import com.olenaznak.services.RoomService;
import com.olenaznak.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultLivingService implements LivingService {

    private LivingDao livingDao;

    private StudentService studentService;

    private RoomService roomService;

    @Override
    public List<Living> getAll() {
        return livingDao.getAll();
    }

    @Override
    public Optional<Living> getById(int id) {
        return livingDao.getById(id);
    }

    @Override
    public Living getByStudent(String name, String surname) {
        Optional<Student> studentOptional = studentService.getByNameAndSurname(name, surname);
        if(studentOptional.isPresent()) {
            Optional<Living> livingOptional = livingDao.getByStudent(studentOptional.get());
            return livingOptional.orElse(null);
        } else {
            return null;
        }
    }

    @Override
    public Living getByRoom(int number) {
        Room room = roomService.getRoomNumber(number);
        if(room != null) {
            Optional<Living> livingOptional = livingDao.getByRoom(room);
            if(livingOptional.isPresent()) {
                return livingOptional.get();
            }
        }
        return null;
    }

    @Override
    public void addLiving(Living living) {
        livingDao.addLiving(living);
    }

    @Override
    public void deleteLiving(Living living) {
        livingDao.deleteLiving(living);
    }

    @Autowired
    public void setLivingDao(LivingDao livingDao) {
        this.livingDao = livingDao;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }
}
