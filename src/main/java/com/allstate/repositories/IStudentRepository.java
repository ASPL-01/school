package com.allstate.repositories;

import com.allstate.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface IStudentRepository extends CrudRepository<Student, Integer> {
    public Student findByEmail(String email);
}
