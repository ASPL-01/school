package com.allstate.controllers;

import com.allstate.dtos.EnrollDto;
import com.allstate.entities.Klass;
import com.allstate.entities.Registration;
import com.allstate.entities.Student;
import com.allstate.services.KlassService;
import com.allstate.services.LearningService;
import com.allstate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Student create(@RequestBody Map<String, String> payload){
        return this.studentService.create(payload.get("email"));
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public Iterable<Student> findAll(){
        return this.studentService.findAll();
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public Student findById(@PathVariable int id){
        return this.studentService.findById(id);
    }

    @RequestMapping(value = "/students/{id}/klasses", method = RequestMethod.GET)
    public List<Klass> getKlassesByStudentId(@PathVariable int id){
        return this.studentService.findById(id).getKlasses();
    }

    @RequestMapping(value = "/students/{id}/registrations", method = RequestMethod.GET)
    public List<Registration> getRegistrationsByStudentId(@PathVariable int id){
        return this.studentService.findById(id).getRegistrations();
    }
}
