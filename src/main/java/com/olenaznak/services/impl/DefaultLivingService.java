package com.olenaznak.services.impl;

import com.olenaznak.dao.LivingDao;
import com.olenaznak.models.Living;
import com.olenaznak.models.Room;
import com.olenaznak.models.Student;
import com.olenaznak.services.LivingService;
import com.olenaznak.services.RoomService;
import com.olenaznak.services.StudentService;
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
    public Optional<Living> getByStudent(String name, String surname) {
        Optional<Student> studentOptional = studentService.getByNameAndSurname(name, surname);
        if(studentOptional.isPresent()) {
            return livingDao.getByStudent(studentOptional.get());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Living> getByRoom(int number) {
        Optional<Room> roomOptional = roomService.getRoomNumber(number);
        if(roomOptional.isPresent()) {
            return livingDao.getByRoom(roomOptional.get());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void addLiving(Living living) {
        livingDao.addLiving(living);
    }

    @Override
    public void deleteLiving(Living living) {
        livingDao.deleteLiving(living);
    }

    public LivingDao getLivingDao() {
        return livingDao;
    }

    public void setLivingDao(LivingDao livingDao) {
        this.livingDao = livingDao;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public RoomService getRoomService() {
        return roomService;
    }

    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }
}
