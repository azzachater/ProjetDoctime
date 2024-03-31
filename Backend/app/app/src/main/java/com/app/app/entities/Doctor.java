package com.app.app.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Doctor extends User {
    private Specialities speciality;
    private String address;
    private int experience;

}
