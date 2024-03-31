package com.app.app.services;

import com.app.app.entities.Comment;
import com.app.app.entities.User;
import com.app.app.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public void creer(Comment comment){
        User user = (User)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setUser(user);
        this.commentRepository.save(comment);
    }
}
