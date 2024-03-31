package com.app.app.services;

import com.app.app.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface UserService {
    User ajouter(User u);
    void deleteUser(User u);
    void deleteUser(int id);
    List<User> getAllUsers();
    User getUserById(int id);
}
