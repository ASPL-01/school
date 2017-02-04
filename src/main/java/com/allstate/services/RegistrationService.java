package com.allstate.services;

import com.allstate.repositories.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private IRegistrationRepository registrationRepository;

    @Autowired
    public void setRegistrationRepository(IRegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
}
