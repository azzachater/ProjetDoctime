package com.app.app.controller;

import com.app.app.entities.Appointment;
import com.app.app.entities.Doctor;
import com.app.app.entities.Patient;
import com.app.app.repository.AppointmentRepository;
import com.app.app.repository.DoctorRepository;
import com.app.app.repository.PatientRepository;
import com.app.app.services.AppointmentService;
import com.app.app.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rendezvous")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @PostMapping("/add/{doctorID}/{patientID}")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment, @PathVariable  int doctorID , @PathVariable  int patientID){
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.addAppointment(appointment, doctorID, patientID));
    }


}
