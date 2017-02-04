package com.allstate.controllers;

import com.allstate.dtos.EnrollDto;
import com.allstate.dtos.RegisterDto;
import com.allstate.entities.Klass;
import com.allstate.services.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LearningController {
    private LearningService learningService;

    @Autowired
    public void setLearningService(LearningService learningService) {
        this.learningService = learningService;
    }

    @RequestMapping(value = "/learning/enroll", method = RequestMethod.POST)
    public Klass enroll(@RequestBody EnrollDto enrollDto){
        return this.learningService.enroll(enrollDto.emails, enrollDto.teacher, enrollDto.klass);
    }

    @RequestMapping(value = "/learning/register", method = RequestMethod.POST)
    public Klass register(@RequestBody RegisterDto registerDto){
        return this.learningService.register(registerDto.emails, registerDto.klass);
    }
}
