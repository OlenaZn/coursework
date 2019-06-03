package com.olenaznak.services.impl;

import com.olenaznak.dao.RoomDao;
import com.olenaznak.models.Room;
import com.olenaznak.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Room getById(int id) {
        Optional<Room> roomOptional = roomDao.getById(id);
        return roomOptional.orElse(null);
    }

    @Override
    public Room getRoomNumber(int num) {
        Optional<Room> roomOptional = roomDao.getRoomNumber(num);
        return roomOptional.orElse(null);
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
    public void deleteRoom(int id) {
        Room room = getById(id);
        roomDao.deleteRoom(room);
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    @Autowired
    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }


}
