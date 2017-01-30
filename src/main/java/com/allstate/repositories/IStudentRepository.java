package com.allstate.repositories;

import com.allstate.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface IStudentRepository extends CrudRepository<Student, Integer> {
    public Student findByEmail(String email);

    String sql = "select sum(g.value * k.credits)/sum(k.credits) as average from grades g inner join klasses k on g.klass_id = k.id  where student_id = :id";
    @Query(value = sql, nativeQuery = true)
    public Optional<BigDecimal> average(@Param("id") int id);
}
