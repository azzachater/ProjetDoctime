package com.app.app.repository;

import com.app.app.entities.Comment;
import com.app.app.entities.Doctor;
import com.app.app.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByDoctor(Doctor doctor);
    List<Comment> findByPatient(Patient patient);

}
