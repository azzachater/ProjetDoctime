package services;

import entities.User;

import java.util.List;

public interface UserService {
    User Ajouter(User u);
    void DeleteUser(User u);
    void DeleteUser(int id);
    List<User> GetAllUsers();
    User GetUserById(int id);
}
