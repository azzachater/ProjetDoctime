package com.app.app.repository;

import com.app.app.entities.Doctor;
import com.app.app.entities.Specialities;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    List<Doctor> findBySpeciality(Specialities speciality);
}
