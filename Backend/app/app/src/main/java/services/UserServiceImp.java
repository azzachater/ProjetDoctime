package services;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository RepUser;
    @Override
    public User Ajouter(User u) {
        RepUser.save(u);
        return u;
    }

    @Override
    public void DeleteUser(User u) {
        RepUser.delete(u);

    }

    @Override
    public void DeleteUser(int id) {
        RepUser.deleteById(id);

    }

    @Override
    public List<User> GetAllUsers() {
        return (List<User>) RepUser.findAll();
    }

    @Override
    public User GetUserById(int id) {
        return (User) RepUser.findAllById(Collections.singleton(id));
    }
}
