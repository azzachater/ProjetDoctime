package controller;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers(){
        return userService.GetAllUsers();
    }
    @GetMapping("/user/{id}")
    @ResponseBody
    public User GetUserById(@PathVariable("id") int id){
        return userService.GetUserById(id);
    }
    @PostMapping("/AjouterUser")
    @ResponseBody
    public User AjouterUser(@RequestBody User u){
        return userService.Ajouter(u);
    }
    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    public void deleteUserById(@PathVariable("id") int id){
        userService.DeleteUser(id);
    }


}
