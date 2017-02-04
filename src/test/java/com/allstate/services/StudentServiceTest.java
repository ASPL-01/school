package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewStudent() throws Exception {
        Student student = this.studentService.create("bob@aol.com");
        assertEquals(5, student.getId());
        assertEquals("bob@aol.com", student.getEmail());
    }

    @Test
    @Transactional
    public void shouldFindStudentById() throws Exception {
        Student student = this.studentService.findById(1);
        assertEquals(1, student.getId());
        assertEquals("aaa@aol.com", student.getEmail());
        assertEquals(3, student.getKlasses().size());
    }

    @Test
    public void shouldFindStudentByEmail() throws Exception {
        Student student = this.studentService.findByEmail("bbb@aol.com");
        assertEquals(2, student.getId());
        assertEquals("bbb@aol.com", student.getEmail());
    }
}
