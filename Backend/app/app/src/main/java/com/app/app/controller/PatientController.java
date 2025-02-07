package com.app.app.controller;

import com.app.app.entities.Comment;
import com.app.app.entities.Doctor;
import com.app.app.entities.Specialities;
import com.app.app.services.CommentService;
import com.app.app.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private DoctorService doctorService;
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable int commentId) {
        commentService.deleteComment(commentId);
        System.out.println("supprission avec succes");
        return ResponseEntity.ok().build();
    }
    @GetMapping("/allComments/{idDoctor}")
    public List<Comment> getAllCommentDoctor(@PathVariable int idDoctor){
        return doctorService.getDoctorComments(idDoctor);
    }
    @GetMapping("allDoctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
    @GetMapping("/speciality/{speciality}")
    public List<Doctor> getBySpeciality(@PathVariable Specialities speciality) {
        return doctorService.getBySpecialty(speciality);
    }


}
