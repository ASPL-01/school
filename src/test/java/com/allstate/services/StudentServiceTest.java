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
}
