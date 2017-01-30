package com.allstate.services;

import com.allstate.entities.Grade;
import com.allstate.entities.Klass;
import com.allstate.repositories.IGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GradeService {
    private IGradeRepository gradeRepository;

    @Autowired
    public void setGradeRepository(IGradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public Grade save(Grade grade){
        return this.gradeRepository.save(grade);
    }

    public Grade findById(int id){
        return this.gradeRepository.findOne(id);
    }
}
