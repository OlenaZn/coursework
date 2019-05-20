package com.olenaznak.services;

import com.olenaznak.dao.ViolationDao;
import com.olenaznak.models.Student;
import com.olenaznak.models.Violation;
import com.olenaznak.services.impl.DefaultViolationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultViolationServiceTest {

    @InjectMocks
    private DefaultViolationService defaultViolationService;

    @Mock
    private ViolationDao violationDao;

    @Mock
    private StudentService studentService;

    private final String NAME = "name";
    private final String SURNAME = "surname";

    @Test
    public void shouldReturnAllViolations() {
        Violation violation = mock(Violation.class);
        List<Violation> list = Arrays.asList(violation, violation);

        when(violationDao.getAll()).thenReturn(list);
        List<Violation> violationList = defaultViolationService.getAll();

        assertNotNull(violationList);
        assertEquals(2, violationList.size());
    }

    @Test
    public void shouldReturnViolationById() {
        int id = 0;
        Violation violation = mock(Violation.class);
        Optional<Violation> violationOptional = Optional.of(violation);

        when(violationDao.getById(id)).thenReturn(violationOptional);

        Optional<Violation> violationResult = defaultViolationService.getById(id);

        assertNotNull(violationResult);
        assertNotNull(violationResult.get());
        assertEquals(violation, violationResult.get());
    }

    @Test
    public void shouldReturnViolationByStudent() {
        Student student = mock(Student.class);
        Optional<Student> studentOptional = Optional.of(student);
        Violation violation = mock(Violation.class);
        Optional<Violation> violationOptional = Optional.of(violation);

        when(studentService.getByNameAndSurname(NAME, SURNAME)).thenReturn(studentOptional);
        when(violationDao.getByStudent(student)).thenReturn(violationOptional);

        Optional<Violation> violationResult = defaultViolationService.getByStudent(NAME, SURNAME);

        assertNotNull(violationResult);
        assertNotNull(violationResult.get());
        assertEquals(violation, violationResult.get());
    }
}
