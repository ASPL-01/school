package com.allstate.controllers;

import com.allstate.dtos.EnrollDto;
import com.allstate.entities.Klass;
import com.allstate.entities.Student;
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

    @RequestMapping(value = "/klasses/{id}/students", method = RequestMethod.GET)
    public List<Student> getStudentsByKlassId(@PathVariable int id){
        return this.klassService.findById(id).getStudents();
    }
}
