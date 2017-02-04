package com.allstate.controllers;

import com.allstate.dtos.EnrollDto;
import com.allstate.entities.Klass;
import com.allstate.entities.Registration;
import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import com.allstate.services.KlassService;
import com.allstate.services.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class KlassController {
    private KlassService klassService;

    @Autowired
    public void setKlassService(KlassService klassService) {
        this.klassService = klassService;
    }

    @RequestMapping(value = "/klasses", method = RequestMethod.POST)
    public Klass create(@RequestBody Klass klass){
        return this.klassService.create(klass);
    }

    @RequestMapping(value = "/klasses", method = RequestMethod.GET)
    public Iterable<Klass> findAll(){
        return this.klassService.findAll();
    }

    @RequestMapping(value = "/klasses/{id}", method = RequestMethod.GET)
    public Klass findById(@PathVariable int id){
        return this.klassService.findById(id);
    }

    @RequestMapping(value = "/klasses/{id}/students", method = RequestMethod.GET)
    public List<Student> getStudentsByKlassId(@PathVariable int id){
        return this.klassService.findById(id).getStudents();
    }

    @RequestMapping(value = "/klasses/{id}/registrations", method = RequestMethod.GET)
    public List<Registration> getRegistrationsByKlassId(@PathVariable int id){
        return this.klassService.findById(id).getRegistrations();
    }

    @RequestMapping(value = "/klasses/{id}/teacher", method = RequestMethod.GET)
    public Teacher getTeacherByKlassId(@PathVariable int id){
        return this.klassService.findById(id).getTeacher();
    }

    @RequestMapping(value = "/klasses/{klassId}/add/{studentId}", method = RequestMethod.POST)
    public Registration addStudent(@PathVariable int klassId, @PathVariable int studentId){
        return this.klassService.addStudent(klassId, studentId);
    }

    @RequestMapping(value = "/klasses/{klassId}/remove/{studentId}", method = RequestMethod.DELETE)
    public void removeStudent(@PathVariable int klassId, @PathVariable int studentId){
        this.klassService.removeStudent(klassId, studentId);
    }
}
