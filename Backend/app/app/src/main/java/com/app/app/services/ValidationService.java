package com.app.app.services;

import com.app.app.entities.User;
import com.app.app.entities.Validation;
import com.app.app.repository.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;
@Service
public class ValidationService {
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private NotificationService notificationService;
    public void enregistrer(User user){
        Validation validation=new Validation();
        validation.setUser(user);
        Instant creation= Instant.now();
        validation.setCreation(creation);
        Instant expiration=creation.plus(10 ,MINUTES);
        validation.setExpiration(expiration);
        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);
        validation.setCode(code);

        this.validationRepository.save(validation);
        this.notificationService.envoyer(validation);

    }

    public Validation lireEnFonctionDuCode(String code) {
        return this.validationRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
    }
}
