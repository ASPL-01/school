package com.allstate.services;

import com.allstate.entities.Grade;
import com.allstate.entities.Klass;
import com.allstate.entities.Student;
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
public class GradeServiceTest {
    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private KlassService klassService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewGrade() throws Exception {
        Student student = this.studentService.findById(1);
        Klass klass = this.klassService.findById(1);
        Grade grade = new Grade(91, true, student, klass);
        grade = this.gradeService.create(grade);
        assertEquals(10, grade.getId());
        assertEquals("aaa@aol.com", grade.getStudent().getEmail());
        assertEquals("Physics 101", grade.getKlass().getName());
    }

    @Test
    public void shouldFindGradeById() throws Exception {
        Grade grade = this.gradeService.findById(2);
        assertEquals(2, grade.getId());
        assertEquals("bbb@aol.com", grade.getStudent().getEmail());
        assertEquals("Physics 101", grade.getKlass().getName());
    }
}
