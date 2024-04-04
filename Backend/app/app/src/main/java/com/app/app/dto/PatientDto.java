package com.app.app.dto;


import com.app.app.entities.Role;
import com.app.app.entities.Specialities;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;

@Data
public class PatientDto {
    private String username;
    private String email;
    private String password;
    private Date dob;
    private String role;
}


