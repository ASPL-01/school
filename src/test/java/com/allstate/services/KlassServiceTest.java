package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import com.allstate.enums.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class KlassServiceTest {
    @Autowired
    private KlassService klassService;

    @Autowired
    private TeacherService teacherService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewKlass() throws Exception {
        Teacher teacher = this.teacherService.findById(1);
        Klass klass = new Klass("Physics 101", Date.valueOf(LocalDate.now()), 4, Department.SCIENCE, 500);
        klass.setTeacher(teacher);
        klass = this.klassService.create(klass);
        assertEquals(4, klass.getId());
        assertEquals("t1", klass.getTeacher().getName());
    }

    @Test
    @Transactional
    public void shouldFindOneKlassById() throws Exception {
        Klass klass = this.klassService.findById(1);
        assertEquals(1, klass.getId());
        assertEquals(3, klass.getStudents().size());
    }

    @Test
    public void shouldFindOneKlassByName() throws Exception {
        Klass klass = this.klassService.findByName("Physics 101");
        assertEquals(1, klass.getId());
    }

    @Test
    public void shouldFindTheTeacherFromKlass() throws Exception {
        Klass klass = this.klassService.findByName("Physics 101");
        assertEquals("t1", klass.getTeacher().getName());
    }
}
