package com.allstate.repositories;

import com.allstate.entities.Registration;
import org.springframework.data.repository.CrudRepository;

public interface IRegistrationRepository extends CrudRepository<Registration, Integer> {
}
