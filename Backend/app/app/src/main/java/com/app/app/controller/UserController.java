package com.app.app.controller;

import com.app.app.Exception.RoleNotFoundException;
import com.app.app.config.JwtService;
import com.app.app.dto.AuthentificationDTO;
import com.app.app.dto.DoctorDto;
import com.app.app.dto.PatientDto;
import com.app.app.entities.Doctor;
import com.app.app.entities.Patient;
import com.app.app.entities.Specialities;
import com.app.app.entities.User;
import com.app.app.services.DoctorServiceImpl;

import com.app.app.services.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping("/signup-patient")
    public String inscription(@RequestBody PatientDto patientDto) throws RoleNotFoundException {
        return this.userService.signUpPatient(patientDto);
    }
    @PostMapping("/signup-doctor")
    public String inscription(@RequestBody DoctorDto doctorDto) throws RoleNotFoundException {
        return this.userService.signUpDoctor(doctorDto);
    }
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

    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    public void deleteUserById(@PathVariable("id") int id){
        userService.deleteUser(id);
    }


    @PostMapping(path = "/activation")
    public void activation(@RequestBody Map<String, String> activation) {
        this.userService.activation(activation);
    }
    @PostMapping(path = "/connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.email()  , authentificationDTO.password())
        );
        if(authenticate.isAuthenticated()){
            return this.jwtService.generate(authentificationDTO.email());
        }


        return null;
    }




}
