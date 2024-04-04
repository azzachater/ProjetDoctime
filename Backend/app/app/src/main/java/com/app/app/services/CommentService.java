package com.app.app.services;

import com.app.app.Exception.CommentNotFoundException;
import com.app.app.entities.Comment;
import com.app.app.entities.Doctor;
import com.app.app.entities.Patient;
import com.app.app.entities.User;
import com.app.app.repository.CommentRepository;
import com.app.app.repository.DoctorRepository;
import com.app.app.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Comment addComment(Comment comment,int doctorID,int patientID){
        /*Doctor doctor = (Doctor) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setDoctor(doctor);
        this.commentRepository.save(comment);*/
        Patient patient = patientRepository.findById(patientID).orElse(null);
        Doctor doctor = doctorRepository.findById(doctorID).orElse(null);
        comment.setDoctor(doctor);
        comment.setPatient(patient);
        Comment comment1=commentRepository.save(comment);
        return comment1;
    }

    public void deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment updateComment(int commentId, Comment updatedComment) throws CommentNotFoundException {
        Optional<Comment> existingCommentOptional = commentRepository.findById(commentId);

        if (existingCommentOptional.isPresent()) {
            Comment existingComment = existingCommentOptional.get();
            existingComment.setMessage(updatedComment.getMessage());
            return commentRepository.save(existingComment);
        } else {
            throw new CommentNotFoundException("Commentaire introuvable avec l'ID : " + commentId);
        }
    }

}

