package com.allstate.repositories;

import com.allstate.entities.Klass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface IKlassRepository extends CrudRepository<Klass, Integer> {
    public Klass findByName(String name);
}
