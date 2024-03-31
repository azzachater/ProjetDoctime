package com.app.app.services;

import com.app.app.entities.Role;
import com.app.app.entities.User;
import com.app.app.entities.Validation;
import com.app.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.app.app.TypeDeRole;

@Service
public class UserServiceImp implements UserService , UserDetailsService {

    @Autowired
    UserRepository repUser;

    @Autowired
    ValidationService validationService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void inscription(User user){
        if(!user.getEmail().contains("@")){
            throw new RuntimeException("Email invalide");
        }
        if(!user.getEmail().contains(".")){
            throw new RuntimeException("Email invalide");
        }
        Optional<User> utilisateurOptional = this.repUser.findByEmail(user.getEmail());
        if(utilisateurOptional.isPresent()) {
            throw  new RuntimeException("Votre mail est déjà utilisé");
        }
        String passwordCrypte=this.passwordEncoder.encode(user.getPassword());

        user.setPassword(passwordCrypte);

        Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeDeRole.PATIENT);
        user.setRole(roleUtilisateur);

        User user1= this.repUser.save(user);
        this.validationService.enregistrer(user1);

    }
    @Override
    public User ajouter(User u) {
        repUser.save(u);
        return u;
    }

    @Override
    public void deleteUser(User u) {
        repUser.delete(u);

    }

    @Override
    public void deleteUser(int id) {
        repUser.deleteById(id);

    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) repUser.findAll();
    }

    @Override
    public User getUserById(int id) {
        return (User) repUser.findAllById(Collections.singleton(id));
    }


    public void activation(Map<String, String> activation) {
        Validation validation = this.validationService.lireEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw  new RuntimeException("Votre code a expiré");
        }
        User userActif = this.repUser.findById(validation.getUser().getUserid()).orElseThrow(() -> new RuntimeException("Utilisateur inconnu"));
        userActif.setActif(true);
        this.repUser.save(userActif);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repUser
                .findByEmail(username)
                .orElseThrow(() -> new  UsernameNotFoundException("Aucun utilisateur ne corespond à cet identifiant"));
    }
    }

