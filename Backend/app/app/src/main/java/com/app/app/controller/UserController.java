package com.app.app.controller;

import com.app.app.config.JwtService;
import com.app.app.dto.AuthentificationDTO;
import com.app.app.entities.Doctor;
import com.app.app.entities.Specialities;
import com.app.app.entities.User;
import com.app.app.services.DoctorServiceImpl;

import com.app.app.services.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.app.app.services.UserService;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController

public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private DoctorServiceImpl doctorService;
    @Autowired
    private UserServiceImp userService;
    @Autowired
    JwtService jwtService;
    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }
    @PostMapping("/ajouterUser")
    @ResponseBody
    public User AjouterUser(@RequestBody User u){
        return userService.ajouter(u);
    }
    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    public void deleteUserById(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

    @GetMapping("/getBySpeciality/{speciality}")
    public List<Doctor> getBySpeciality(@PathVariable Specialities speciality) {
        return doctorService.getBySpecialty(speciality);
    }
    @PostMapping("/inscription")
    public void inscription(@RequestBody User user){
        log.info("Inscription");
        this.userService.inscription(user);

    }
    @PostMapping(path = "/activation")
    public void activation(@RequestBody Map<String, String> activation) {
        this.userService.activation(activation);
    }
    @PostMapping(path = "/connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.username(), authentificationDTO.password())
        );
        if(authenticate.isAuthenticated()){
            return this.jwtService.generate(authentificationDTO.username());
        }


        return null;
    }




}
