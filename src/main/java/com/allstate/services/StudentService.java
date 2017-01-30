package com.allstate.services;

import com.allstate.entities.Student;
import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private IStudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(String email){
        Student s = new Student(email);
        return this.studentRepository.save(s);
    }

    public Student findById(int id){
        return this.studentRepository.findOne(id);
    }

    public Student findByEmail(String email){
        return this.studentRepository.findByEmail(email);
    }

    public Iterable<Student> saveAll(List<Student> students){
        return this.studentRepository.save(students);
    }
}
