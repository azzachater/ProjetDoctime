package com.app.app.repository;

import com.app.app.entities.Appointment;
import com.app.app.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    List<Appointment> findByDoctor(Doctor doctor);
}
