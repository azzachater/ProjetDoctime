package com.app.app.repository;

import com.app.app.entities.Patient;
import com.app.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Patient findByUsername(String username);

}
