package com.olenaznak.services;

import com.olenaznak.dao.LivingDao;
import com.olenaznak.models.Living;
import com.olenaznak.models.Room;
import com.olenaznak.models.Student;
import com.olenaznak.services.impl.DefaultLivingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultLivingServiceTest {
    @InjectMocks
    private DefaultLivingService defaultLivingService;

    @Mock
    private LivingDao livingDao;
    @Mock
    private StudentService studentService;
    @Mock
    private RoomService roomService;

    private final String NAME = "name";
    private final String SURNAME = "surname";

    @Test
    public void shouldReturnAllLivings() {
        Living living = mock(Living.class);
        List<Living> list = Arrays.asList(living, living);

        when(livingDao.getAll()).thenReturn(list);
        List<Living> livingList = defaultLivingService.getAll();

        assertNotNull(livingList);
        assertEquals(2, livingList.size());
    }

    @Test
    public void shouldReturnViolationById() {
        int id = 0;
        Living living = mock(Living.class);
        Optional<Living> livingOptional = Optional.of(living);

        when(livingDao.getById(id)).thenReturn(livingOptional);

        Optional<Living> livingResult = defaultLivingService.getById(id);

        assertNotNull(livingResult);
        assertNotNull(livingResult.get());
        assertEquals(living, livingResult.get());
    }

    @Test
    public void shouldReturnViolationByStudent() {
        Student student = mock(Student.class);
        Optional<Student> studentOptional = Optional.of(student);
        Living living = mock(Living.class);
        Optional<Living> livingOptional = Optional.of(living);

        when(studentService.getByNameAndSurname(NAME, SURNAME)).thenReturn(studentOptional);
        when(livingDao.getByStudent(student)).thenReturn(livingOptional);

        Living livingResult = defaultLivingService.getByStudent(NAME, SURNAME);

        assertNotNull(livingResult);
        assertEquals(living, livingResult);
    }

    @Test
    public void testShouldReturnViolationByRoom() {
        int num = 0;
        Room room = mock(Room.class);
        Optional<Room> roomOptional = Optional.of(room);
        Living living = mock(Living.class);
        Optional<Living> livingOptional = Optional.of(living);

        when(roomService.getRoomNumber(num)).thenReturn(room);
        when(livingDao.getByRoom(room)).thenReturn(livingOptional);

        Living livingResult = defaultLivingService.getByRoom(num);

        assertNull(livingResult);
        assertEquals(living, livingResult);
    }

}
