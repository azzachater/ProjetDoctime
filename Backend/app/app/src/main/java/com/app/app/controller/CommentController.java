package com.app.app.controller;

import com.app.app.Exception.CommentNotFoundException;
import com.app.app.entities.Appointment;
import com.app.app.entities.Comment;
import com.app.app.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;


    @PostMapping("/add/{doctorID}/{patientID}")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment, @PathVariable int doctorID , @PathVariable  int patientID){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.addComment(comment, doctorID, patientID));
}
    @PutMapping("/update/{idComment}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment updatedComment,@PathVariable int idComment) throws CommentNotFoundException {
        Comment comment = commentService.updateComment(idComment, updatedComment);
        return ResponseEntity.ok(comment);
    }
}
