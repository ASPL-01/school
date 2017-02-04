package com.allstate.repositories;

import com.allstate.entities.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IRegistrationRepository extends CrudRepository<Registration, Integer> {
    @Query("select r from Registration r join r.klass k join r.student s where k.id = :kid and s.id = :sid")
    public Registration findByKlassAndStudent(@Param("kid") int kid, @Param("sid") int sid);
}
