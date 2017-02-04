package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LearningService {
    private StudentService studentService;
    private KlassService klassService;
    private TeacherService teacherService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setKlassService(KlassService klassService) {
        this.klassService = klassService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public Klass enroll(List<String> email, Teacher teacher, Klass klass){
        List<Student> students = email.stream().map(e -> new Student(e)).collect(Collectors.toList());
        klass.setTeacher(teacher);
        klass.setStudents(students);

        this.studentService.createAll(students);
        this.teacherService.create(teacher);
        this.klassService.create(klass);

        return klass;
    }

    public Klass register(List<String> email, Klass klass){
        List<Student> students = email.stream().map(e -> new Student(e)).collect(Collectors.toList());
        klass.setStudents(students);

        this.studentService.createAll(students);
        this.klassService.create(klass);

        return klass;
    }
}
