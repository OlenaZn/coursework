package com.olenaznak.services;

import com.olenaznak.dao.RoomDao;
import com.olenaznak.models.Room;
import com.olenaznak.services.impl.DefaultRoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultRoomServiceTest {

    @InjectMocks
    private DefaultRoomService defaultRoomService;

    @Mock
    private RoomDao roomDao;

    @Test
    public void shouldReturnAllRooms() {
        Room room = mock(Room.class);
        List<Room> list = Arrays.asList(room, room);

        when(roomDao.getAll()).thenReturn(list);
        List<Room> roomList = defaultRoomService.getAll();

        assertNotNull(roomList);
        assertEquals(2, roomList.size());
    }

    @Test
    public void shouldReturnRoomById() {
        int id = 0;
        Room room = mock(Room.class);
        Optional<Room> roomOptional = Optional.of(room);

        when(roomDao.getById(id)).thenReturn(roomOptional);

        Optional<Room> roomResult = defaultRoomService.getById(id);

        assertNotNull(roomResult);
        assertNotNull(roomResult.get());
        assertEquals(room, roomResult.get());
    }

    @Test
    public void shouldReturnRoomByNumber() {
        int num = 0;
        Room room = mock(Room.class);
        Optional<Room> roomOptional = Optional.of(room);

        when(roomDao.getRoomNumber(num)).thenReturn(roomOptional);

        Optional<Room> roomResult = defaultRoomService.getRoomNumber(num);

        assertNotNull(roomResult);
        assertNotNull(roomResult.get());
        assertEquals(room, roomResult.get());
    }

    @Test
    public void shouldReturnRoomsWithFreeBeds() {
        Room room = mock(Room.class);
        List<Room> list = Arrays.asList(room, room);

        when(roomDao.getRoomsWithFreeBeds()).thenReturn(list);

        List<Room> roomList = roomDao.getRoomsWithFreeBeds();

        assertNotNull(roomList);
        assertEquals(2, roomList.size());
    }
}
