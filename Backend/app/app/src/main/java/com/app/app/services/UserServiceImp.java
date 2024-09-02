package com.app.app.services;

import com.app.app.Exception.RoleNotFoundException;
import com.app.app.dto.DoctorDto;
import com.app.app.dto.PatientDto;
import com.app.app.entities.*;
import com.app.app.repository.DoctorRepository;
import com.app.app.repository.PatientRepository;
import com.app.app.repository.RoleRepository;
import com.app.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService , UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository repPatient;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    ValidationService validationService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String signUpPatient(PatientDto patientDto) throws RoleNotFoundException {
        if(!patientDto.getEmail().contains("@")){
            return "Invalid Email";
        }
        if(!patientDto.getEmail().contains(".")){
            return "Invalid Email";
        }
        Optional<User> utilisateurOptional = this.userRepository.findByEmail(patientDto.getEmail());
        if(utilisateurOptional.isPresent()) {
            return "Email Already Used";
        }
        Role userRole = roleRepository.findByName(ERole.PATIENT)
                .orElseThrow(() -> new RoleNotFoundException("Role not found."));
        Patient patient = new Patient();
        patient.setEmail(patientDto.getEmail());
        patient.setUsername(patientDto.getUsername());
        patient.setDob(patientDto.getDob());
        patient.setPassword(this.passwordEncoder.encode(patientDto.getPassword()));
        patient.setRole(userRole);
        userRepository.save(patient);
        validationService.enregistrer(patient);

        return "Patient Added successfully";
    }
    public String signUpDoctor(DoctorDto doctorDto) throws RoleNotFoundException {
        if(!doctorDto.getEmail().contains("@")){
            return "Invalid Email";
        }
        if(!doctorDto.getEmail().contains(".")){
            return "Invalid Email";
        }
        Optional<User> utilisateurOptional = this.userRepository.findByEmail(doctorDto.getEmail());
        if(utilisateurOptional.isPresent()) {
            return "Email Already Used";
        }
        Role userRole = roleRepository.findByName(ERole.DOCTOR)
                .orElseThrow(() -> new RoleNotFoundException("Role not found."));
        Doctor doctor = new Doctor();
        doctor.setEmail(doctorDto.getEmail());
        doctor.setUsername(doctorDto.getUsername());
        doctor.setDob(doctorDto.getDob());
        doctor.setPassword(this.passwordEncoder.encode(doctorDto.getPassword()));
        doctor.setRole(userRole);
        Specialities speciality = doctorDto.getSpeciality();
        System.out.println(speciality.name());
        doctor.setSpeciality(speciality);
        System.out.println(doctor.getSpeciality());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setExperience(doctorDto.getExperience());
        System.out.println(doctor.toString());
        userRepository.save(doctor);
        validationService.enregistrer(doctor);
        return "Doctor Added successfully";
    }


    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return (User) userRepository.findAllById(Collections.singleton(id));
    }


    public void activation(Map<String, String> activation) {
        Validation validation = this.validationService.lireEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw  new RuntimeException("Votre code a expiré");
        }
        User userActif = this.userRepository.findById(validation.getUser().getUserid()).orElseThrow(() -> new RuntimeException("Utilisateur inconnu"));
        userActif.setActif(true);
        this.userRepository.save(userActif);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository
                .findByEmail(username)
                .orElseThrow(() -> new  UsernameNotFoundException("Aucun utilisateur ne corespond à cet identifiant"));
    }
    }

