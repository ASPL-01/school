package com.allstate.repositories;

import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {
    @Query("select distinct s from Student s join s.klasses k join k.teacher t where t.id = :id")
    public List<Student> findAllStudentsTaughyByTeacherId(@Param("id") int id);

    public Teacher findByName(String name);
    public List<Teacher> findByGender(Gender gender);
    public List<Teacher> findByAgeGreaterThan(int age);
}
