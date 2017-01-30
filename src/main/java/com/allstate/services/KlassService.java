package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.repositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlassService {
    private IKlassRepository klassRepository;

    @Autowired
    public void setKlassRepository(IKlassRepository klassRepository) {
        this.klassRepository = klassRepository;
    }

    public Klass create(Klass klass){
        return this.klassRepository.save(klass);
    }

    public Klass findById(int id){
        return this.klassRepository.findOne(id);
    }

    public Klass findByName(String name){
        return this.klassRepository.findByName(name);
    }
}
