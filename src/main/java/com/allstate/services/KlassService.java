package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Registration;
import com.allstate.entities.Student;
import com.allstate.repositories.IKlassRepository;
import com.allstate.repositories.IRegistrationRepository;
import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class KlassService {
    private IKlassRepository klassRepository;
    private IStudentRepository studentRepository;
    private IRegistrationRepository registrationRepository;

    @Autowired
    public void setKlassRepository(IKlassRepository klassRepository) {
        this.klassRepository = klassRepository;
    }

    @Autowired
    public void setStudentRepository(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setRegistrationRepository(IRegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public Klass create(Klass klass){
        return this.klassRepository.save(klass);
    }

    public Klass findById(int id){
        return this.klassRepository.findOne(id);
    }

    public Iterable<Klass> findAll(){
        return this.klassRepository.findAll();
    }

    public Klass findByName(String name){
        return this.klassRepository.findByName(name);
    }

    public Registration addStudent(int klassId, int studentId){
        Klass klass = this.klassRepository.findOne(klassId);
        Student student = this.studentRepository.findOne(studentId);
        Registration registration = new Registration(student, klass);
        return this.registrationRepository.save(registration);
    }

    public void removeStudent(int klassId, int studentId){
        Registration registration = this.registrationRepository.findByKlassAndStudent(klassId, studentId);
        this.registrationRepository.delete(registration);
    }
}
