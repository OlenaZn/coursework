package com.olenaznak.services;

import com.olenaznak.models.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> getAll();

    Optional<Room> getById(int id);

    Optional<Room> getRoomNumber(int num);

    List<Room> getRoomsWithFreeBeds();

    void addRoom(Room room);

    void deleteRoom(Room room);
}
