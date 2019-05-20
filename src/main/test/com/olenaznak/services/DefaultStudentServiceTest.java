package com.olenaznak.services;

import com.olenaznak.dao.StudentDao;
import com.olenaznak.models.Student;
import com.olenaznak.services.impl.DefaultStudentService;
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
public class DefaultStudentServiceTest {

    @InjectMocks
    private DefaultStudentService defaultStudentService;

    @Mock
    private StudentDao studentDao;

    private final String NAME = "name";
    private final String SURNAME = "surname";

    @Test
    public void shouldReturnAllStudents() {
        Student student = mock(Student.class);
        List<Student> list = Arrays.asList(student, student);

        when(studentDao.getAll()).thenReturn(list);
        List<Student> studentList = defaultStudentService.getAllStudents();

        assertNotNull(studentList);
        assertEquals(2, studentList.size());
    }

    @Test
    public void shouldReturnStudentById() {
        int id = 0;
        Student student = mock(Student.class);
        Optional<Student> studentOptional = Optional.of(student);

        when(studentDao.getById(id)).thenReturn(studentOptional);

        Optional<Student> studentResult = defaultStudentService.getStudentById(id);

        assertNotNull(studentResult);
        assertNotNull(studentResult.get());
        assertEquals(student, studentResult.get());
    }

    @Test
    public void shouldReturnStudentnByNameAndSurname() {
        Student student = mock(Student.class);
        Optional<Student> studentOptional = Optional.of(student);

        when(studentDao.getByNameAndSurname(NAME, SURNAME)).thenReturn(studentOptional);

        Optional<Student> studentResult = defaultStudentService.getByNameAndSurname(NAME, SURNAME);

        assertNotNull(studentResult);
        assertNotNull(studentResult.get());
        assertEquals(student, studentResult.get());
    }
}
