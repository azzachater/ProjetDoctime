package com.app.app.services;

import com.app.app.entities.Appointment;
import com.app.app.entities.Comment;
import com.app.app.entities.Doctor;
import com.app.app.entities.Specialities;
import com.app.app.repository.AppointmentRepository;
import com.app.app.repository.CommentRepository;
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


    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Appointment> getDoctorAppointments(int doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        System.out.println("Total appointments for doctor : "+doctor.getUsername() +" " + appointmentRepository.findByDoctor(doctor).size());
        return appointmentRepository.findByDoctor(doctor);
    }

    @Override
    public List<Comment> getDoctorComments(int doctorid) {
        Doctor doctor=doctorRepository.findById(doctorid).orElse(null);
        System.out.println("Total appointments for doctor : "+doctor.getUsername() +" " +commentRepository.findByDoctor(doctor).size());
        return commentRepository.findByDoctor(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getBySpecialty (Specialities speciality){
        return doctorRepository.findBySpeciality(speciality);
    }
}
