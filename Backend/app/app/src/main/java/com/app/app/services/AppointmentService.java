package com.app.app.services;

import com.app.app.entities.Appointment;
import com.app.app.entities.Doctor;
import com.app.app.entities.Patient;
import com.app.app.repository.AppointmentRepository;
import com.app.app.repository.DoctorRepository;
import com.app.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class AppointmentService {


    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Appointment addAppointment(Appointment appointment, int doctorID , int patientID) {
        Patient patient = patientRepository.findById(patientID).orElse(null);
        Doctor doctor = doctorRepository.findById(doctorID).orElse(null);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        Appointment appoint = appointmentRepository.save(appointment);
        return appoint;
    }



}
