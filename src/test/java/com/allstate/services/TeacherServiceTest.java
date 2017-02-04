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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewTeacher() throws Exception {
        Teacher teacher = new Teacher("alice", 22, Gender.FEMALE);
        teacher = this.teacherService.create(teacher);
        assertEquals(4, teacher.getId());
        assertEquals("alice", teacher.getName());
        assertEquals(Gender.FEMALE, teacher.getGender());
    }

    @Test
    public void shouldFindTeacherById() throws Exception {
        Teacher teacher = this.teacherService.findById(1);
        assertEquals(1, teacher.getId());
        assertEquals("t1", teacher.getName());
    }

    @Test
    public void shouldFindTeacherByName() throws Exception {
        Teacher teacher = this.teacherService.findByName("t2");
        assertEquals(2, teacher.getId());
        assertEquals("t2", teacher.getName());
    }

    @Test
    public void shouldFindFemaleTeachers() throws Exception {
        List<Teacher> teachers = this.teacherService.findByGender(Gender.FEMALE);
        assertEquals(2, teachers.size());
    }

    @Test
    public void shouldFindTeachersOlderThan50() throws Exception {
        List<Teacher> teachers = this.teacherService.findByAgeGreaterThan(50);
        assertEquals(1, teachers.size());
    }

    @Test
    public void shouldNotFindAnyTeachersOlderThan100() throws Exception {
        List<Teacher> teachers = this.teacherService.findByAgeGreaterThan(100);
        assertEquals(0, teachers.size());
    }

    @Test
    @Transactional
    public void shouldFindAllTheKlassesTaughtByTeacher() throws Exception {
        List<Klass> klasses = this.teacherService.findById(2).getKlasses();
        assertEquals(2, klasses.size());
    }

    @Test
    @Transactional
    public void shouldFindNoKlassesTaughtByTeacher() throws Exception {
        List<Klass> klasses = this.teacherService.findById(3).getKlasses();
        assertEquals(0, klasses.size());
    }

    @Test
    public void shouldFindAllStudentsTaughtByATeacher() throws Exception {
        List<Student> students = this.teacherService.findAllStudentsTaughyByTeacherId(1);
        assertEquals(3, students.size());
    }
}
