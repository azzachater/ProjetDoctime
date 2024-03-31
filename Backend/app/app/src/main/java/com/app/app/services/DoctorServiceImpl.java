package com.app.app.services;

import com.app.app.entities.Doctor;
import com.app.app.entities.Specialities;
import com.app.app.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class DoctorServiceImpl implements DoctorService  {
    @Autowired
    DoctorRepository doctorRepository;


    public List<Doctor> getBySpecialty (Specialities speciality){
        return doctorRepository.findBySpeciality(speciality);
    }
}
