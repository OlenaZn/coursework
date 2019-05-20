package com.olenaznak.services.impl;

import com.olenaznak.dao.RoomDao;
import com.olenaznak.models.Room;
import com.olenaznak.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultRoomService implements RoomService {

    private RoomDao roomDao;

    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    @Override
    public Optional<Room> getById(int id) {
        return roomDao.getById(id);
    }

    @Override
    public Optional<Room> getRoomNumber(int num) {
        return roomDao.getRoomNumber(num);
    }

    @Override
    public List<Room> getRoomsWithFreeBeds() {
        return roomDao.getRoomsWithFreeBeds();
    }

    @Override
    public void addRoom(Room room) {
        roomDao.addRoom(room);
    }

    @Override
    public void deleteRoom(Room room) {
        roomDao.deleteRoom(room);
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }
}
