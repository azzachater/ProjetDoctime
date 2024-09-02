package com.app.app.controller;

import com.app.app.entities.Appointment;
import com.app.app.entities.Comment;
import com.app.app.services.CommentService;
import com.app.app.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @GetMapping("/appointments/{doctorID}")
    public List<Appointment> getAllAppointments(@PathVariable int doctorID){
        return doctorService.getDoctorAppointments(doctorID);
    }


}
