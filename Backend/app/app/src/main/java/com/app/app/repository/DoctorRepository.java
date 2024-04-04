package com.app.app.repository;

import com.app.app.entities.Doctor;
import com.app.app.entities.Specialities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findBySpeciality(Specialities speciality);
}
