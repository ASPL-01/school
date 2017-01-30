package com.allstate.repositories;

import com.allstate.entities.Grade;
import org.springframework.data.repository.CrudRepository;

public interface IGradeRepository extends CrudRepository<Grade, Integer> {
}
