package com.app.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "doctor_id")
public class Doctor extends User {
    private Specialities speciality;
    private String address;
    private int experience;
    
}
