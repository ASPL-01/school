package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearningService {
    private StudentService studentService;
    private KlassService klassService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setKlassService(KlassService klassService) {
        this.klassService = klassService;
    }

    public Klass enroll(List<String> emails, Klass klass){
        List<Student> students = emails.stream().map(e -> new Student(e)).collect(Collectors.toList());
        this.studentService.saveAll(students);
        klass.setStudents(students);
        klass = this.klassService.create(klass);
        return klass;
    }
}
