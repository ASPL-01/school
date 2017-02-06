package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import com.allstate.enums.Department;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class LearningServiceTest {
    @Autowired
    private LearningService learningService;

    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shoudEnrollStudents() throws Exception {
        Date date = Date.valueOf("2015-11-03");
        List<String> emails = Arrays.asList("bobaabb", "saraaabb", "joeaabb", "samaabb");
        Teacher teacher = new Teacher("frank", 33, Gender.MALE);
        Klass klass = new Klass("chemistry", date, 4, Department.SCIENCE, 300);

        klass = this.learningService.enroll(emails, teacher, klass);

        assertEquals(4, klass.getId());
        assertEquals(4, klass.getStudents().size());
        assertEquals("frank", klass.getTeacher().getName());
    }

    @Test
    public void shouldRollbackChangesDueToDatabaseError() throws Exception {
        KlassService fakeKlassService = mock(KlassService.class);
        when(fakeKlassService.create(any())).thenThrow(new javax.persistence.PersistenceException());

        this.learningService.setKlassService(fakeKlassService);

        Date date = Date.valueOf("2015-11-03");
        List<String> emails = Arrays.asList("bobaabb", "saraaabb", "joeaabb", "samaabb");
        Teacher teacher = new Teacher("frank", 33, Gender.MALE);
        Klass klass = new Klass("chemistry", date, 4, Department.SCIENCE, 300);

        try{
            klass = this.learningService.enroll(emails, teacher, klass);
        }catch (PersistenceException e){}

        Student student1 = this.studentService.findByEmail("aaa@aol.com");
        Student student2 = this.studentService.findByEmail("sam");
        assertNotNull(student1);
        assertNull(student2);
    }
}
