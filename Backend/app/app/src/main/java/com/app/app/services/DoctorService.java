package com.app.app.services;

import com.app.app.entities.Appointment;
import com.app.app.entities.Comment;
import com.app.app.entities.Doctor;
import com.app.app.entities.Specialities;
import com.app.app.repository.AppointmentRepository;
import com.app.app.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {



    List<Appointment> getDoctorAppointments(int doctorId);
    List<Comment> getDoctorComments(int doctorid);

    List<Doctor> getAllDoctors();

    List<Doctor> getBySpecialty(Specialities speciality);
}
