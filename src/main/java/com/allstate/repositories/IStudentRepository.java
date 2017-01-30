package com.allstate.repositories;

import com.allstate.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Integer> {
}
