package com.app.app.services;

import com.app.app.entities.Patient;
import com.app.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient getByUsername(String patientEmail) {
        return this.patientRepository.findByUsername(patientEmail);
    }
}
