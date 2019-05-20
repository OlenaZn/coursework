package com.olenaznak.dao;

import com.olenaznak.models.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RoomDao {
    private List<Room> roomList;

    public RoomDao(List<Room> roomList) {
        this.roomList = roomList;
    }

    public RoomDao() {
        roomList = new ArrayList<>();
    }

    public List<Room> getAll() {
        return roomList;
    }

    public Optional<Room> getById(int id) {
        return roomList.stream().filter(violation -> id == violation.getId()).findFirst();
    }

    public Optional<Room> getRoomNumber(int num) {
        return roomList.stream()
                .filter(room -> room.getRoomNumber()==num)
                .findFirst();
    }

    public List<Room> getRoomsWithFreeBeds() {
        return roomList.stream()
                .filter(room -> room.getFreeBedsAmount()>0).collect(Collectors.toList());
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void deleteRoom(Room room) {
        roomList.remove(room);
    }
}
